package org.example.transformation.value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Practice2 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /* union算子
        JavaRDD<Integer> rdd1 = sc.parallelize(Arrays.asList(1,2,3));
        JavaRDD<Integer> rdd2 = sc.parallelize(Arrays.asList(4,5,6));
        JavaRDD<Integer> unionRDD = rdd1.union(rdd2);

        List<Integer> output = unionRDD.collect();
        System.out.println(output);
        */

        /* cartesian算子
        JavaRDD<Integer> rdd1 = sc.parallelize(Arrays.asList(1,2));
        JavaRDD<Integer> rdd2 = sc.parallelize(Arrays.asList(3,4));
        JavaPairRDD<Integer,Integer> cartesianRDD = rdd1.cartesian(rdd2);

        List<Tuple2<Integer, Integer>> output = cartesianRDD.collect();
        System.out.println(output);
        */

        /* groupBy算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5,6));
        JavaPairRDD<String,Iterable<Integer>> groupRDD = rdd.groupBy(num -> num % 2 == 0 ? "even" : "odd");
        List<Tuple2<String,Iterable<Integer>>> output = groupRDD.collect();
        System.out.println(output);
        */

        // groupByKey算子
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",10),
                new Tuple2<>("banana",5),
                new Tuple2<>("apple",15),
                new Tuple2<>("banana",3)
        ));
        JavaPairRDD<String,Iterable<Integer>> groupedRDD = rdd.groupByKey();
        List<Tuple2<String,Iterable<Integer>>> output = groupedRDD.collect();
        System.out.println(output);

        sc.close();
    }
}
