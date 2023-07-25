package org.example.transformation.key_value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Practice4 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /* mapValues算子
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("orange",8)
        ));
        JavaPairRDD<String,Integer> mapValuesRDD = rdd.mapValues(value -> value * 2);
        List<Tuple2<String,Integer>> output = mapValuesRDD.collect();
        System.out.println(output);
        */

        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("apple",10),
                new Tuple2<>("banana",7)
        ));
        JavaPairRDD<String,Integer> combinedRDD = rdd.combineByKey(
                value -> value,            //创建组合器函数
                (aggValue,newValue) -> aggValue + newValue,    //合并值函数
                (aggValue1,aggValue2) -> aggValue1 + aggValue2  //合并组合器函数
        );
        List<Tuple2<String,Integer>> output = combinedRDD.collect();
        System.out.println(output);


        sc.close();
    }
}
