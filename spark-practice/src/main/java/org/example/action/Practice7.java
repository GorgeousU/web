package org.example.action;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class Practice7 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /* take算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        List<Integer> takenList = rdd.take(3);
        for (Integer num : takenList) {
            System.out.println(num);
        }
        */

        /* takeSample算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        List<Integer> sampleList = rdd.takeSample(false,3);
        for (Integer num : sampleList) {
            System.out.println(num);
        }
        */

        /* reduce算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        Integer sum = rdd.reduce((num1,num2) -> num1 + num2);
        System.out.println("Sum: " + sum);
        */

        /* aggregate算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        int sum = rdd.aggregate(
                0,   //初始值
                (acc,num) -> acc + num,   //分区内聚合
                (acc1,acc2) -> acc1 + acc2   //分区间聚合
        );
        System.out.println("Sum: " + sum);
        */

        /* zip算子
        JavaRDD<String> rdd1 = sc.parallelize(Arrays.asList("apple", "banana", "orange"));
        JavaRDD<Integer> rdd2 = sc.parallelize(Arrays.asList(5, 3, 2));
        JavaPairRDD<String,Integer> zipRDD = rdd1.zip(rdd2);
        zipRDD.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));
        */

        // zipWithIndex算子
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("apple", "banana", "orange"));
        JavaPairRDD<String,Long> zipWithIndexRDD = rdd.zipWithIndex();
        zipWithIndexRDD.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));


        sc.close();
    }
}
