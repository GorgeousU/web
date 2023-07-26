package org.example.transformation.key_value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Practice5 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);


        /* join算子
        JavaPairRDD<String,Integer> rdd1 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3)
        ));
        JavaPairRDD<String,Double> rdd2 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",3.0),
                new Tuple2<>("banana",2.5)
        ));
        JavaPairRDD<String,Tuple2<Integer,Double>> joinRDD = rdd1.join(rdd2);
        List<Tuple2<String,Tuple2<Integer,Double>>> output = joinRDD.collect();
        System.out.println(output);
        */

        /* leftOuterJoin算子
        JavaPairRDD<String,Integer> rdd1 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3)
        ));
        JavaPairRDD<String,Double> rdd2 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",3.0),
                new Tuple2<>("orange",1.5)
        ));
        JavaPairRDD<String, Tuple2<Integer, Optional<Double>>> leftJoinRDD = rdd1.leftOuterJoin(rdd2);
        List<Tuple2<String,Tuple2<Integer,Optional<Double>>>> output = leftJoinRDD.collect();
        System.out.println(output);
        */

        /* rightOuterJoin算子
        JavaPairRDD<String,Integer> rdd1 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("orange",7)
        ));
        JavaPairRDD<String,Double> rdd2 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",3.0),
                new Tuple2<>("banana",2.5)
        ));
        JavaPairRDD<String,Tuple2<Optional<Integer>,Double>> rightJoinRDD = rdd1.rightOuterJoin(rdd2);
        List<Tuple2<String,Tuple2<Optional<Integer>,Double>>> output = rightJoinRDD.collect();
        System.out.println(output);
        */

        // fullOuterJoin算子
        JavaPairRDD<String,Integer> rdd1 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3)
        ));
        JavaPairRDD<String,Double> rdd2 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",3.0),
                new Tuple2<>("orange",1.5)
        ));
        JavaPairRDD<String,Tuple2<Optional<Integer>,Optional<Double>>> fullJoinRDD = rdd1.fullOuterJoin(rdd2);
        List<Tuple2<String,Tuple2<Optional<Integer>,Optional<Double>>>> output = fullJoinRDD.collect();
        System.out.println(output);

        sc.close();
    }
}
