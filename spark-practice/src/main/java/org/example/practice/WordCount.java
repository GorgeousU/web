package org.example.practice;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        //读取文件
        JavaRDD<String> textRDD = sc.textFile("src/main/java/org/example/practice/text.txt");
        //利用flatMap算子，split将数据分隔开，再通过iterator迭代器将分割后的数据元素返回
        JavaRDD<String> words = textRDD.flatMap(x -> Arrays.stream(x.split(" ")).iterator());
        //mapToPair算子用于计数
        JavaPairRDD<String,Integer> wordMap = words.mapToPair(x -> new Tuple2<>(x,1));
        //reduceByKey算子根据key来聚合
        JavaPairRDD<String,Integer> result = wordMap.reduceByKey((x,y) -> x + y);
        result.foreach(elem -> System.out.println(elem));

        sc.close();
    }
}
