package org.example.action;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Map;

public class Practice6 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /* foreach算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        rdd.foreach(num -> System.out.println(num));
        */

        /* collectAsMap算子
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("orange",2)
        ));
        Map<String,Integer> collectMap = rdd.collectAsMap();
        for (Map.Entry<String,Integer> entry : collectMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */

        /* count算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        long count = rdd.count();
        System.out.println("Count: " + count);
        */

        /* countByKey算子
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("apple",10),
                new Tuple2<>("orange",2)
        ));
        Map<String,Long> counts = rdd.countByKey();
        for (Map.Entry<String,Long> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        */

        // countByValue算子
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("apple","banana","apple","orange"));
        Map<String,Long> counts = rdd.countByValue();
        for (Map.Entry<String,Long> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }



        sc.close();
    }
}
