package org.example.transformation.value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        //创建SparkConf对象并设置应用程序名称
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        //创建JavaSparkContext对象
        JavaSparkContext sc = new JavaSparkContext(conf);

        /*  map算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        JavaRDD<Integer> resultRDD = rdd.map(x -> x*2);
        List<Integer> output = resultRDD.collect();
        System.out.println(output);
        */

        /* flatmap算子
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("Hello Spark","Big Data"));
        JavaRDD<String> resultRDD = rdd.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
        List<String> output = resultRDD.collect();
        System.out.println(output);
        */

        /*  mapPartitions算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5),2);
        JavaRDD<Integer> resultRDD = rdd.mapPartitions(iter -> {
            List<Integer> partitionSum = new ArrayList<>();
            int sum = 0;
            while (iter.hasNext()) {
                sum +=iter.next();
            }
            partitionSum.add(sum);
            return partitionSum.iterator();
        });
        List<Integer> output = resultRDD.collect();
        System.out.println(output);
        */

        // mapPartitionsWithIndex算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5),2);
        JavaRDD<String> resultRDD = rdd.mapPartitionsWithIndex((index,iterator) -> {
            List<String> output = new ArrayList<>();
            while (iterator.hasNext()) {
                int num = iterator.next();
                output.add("Partition " + index + " : " + num);
            }
            return output.iterator();
        },true);
        List<String> output = resultRDD.collect();
        System.out.println(output);

        //关闭JavaSparkContext
        sc.close();
    }
}