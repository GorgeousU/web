package org.example.transformation.value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

import java.util.Arrays;
import java.util.List;

public class Practice3 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("RDDTest").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        /* filter算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5,6));
        JavaRDD<Integer> filterRDD = rdd.filter(num -> num % 2 == 0);
        List<Integer> output = filterRDD.collect();
        System.out.println(output);
         */

        /* distinct算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,2,4,5,3,6));
        JavaRDD<Integer> distinctRDD = rdd.distinct();
        List<Integer> output = distinctRDD.collect();
        System.out.println(output);
        */

        /* subtract算子
        JavaRDD<Integer> rdd1 = sc.parallelize(Arrays.asList(1,2,3,4,5));
        JavaRDD<Integer> rdd2 = sc.parallelize(Arrays.asList(4,5,6));
        JavaRDD<Integer> subtractRDD = rdd1.subtract(rdd2);
        List<Integer> output = subtractRDD.collect();
        System.out.println(output);
        */

        /* sample算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        JavaRDD<Integer> sampleRDD = rdd.sample(false,0.5,42);
        List<Integer> output = sampleRDD.collect();
        System.out.println(output);
        */

        /* cache算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5,6));
        rdd.cache();
        List<Integer> cacheRDD = rdd.collect();
        System.out.println(cacheRDD);
        */

        // persist算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5,6));
        rdd.persist(StorageLevel.MEMORY_AND_DISK());
        List<Integer> persistRDD = rdd.collect();
        System.out.println(persistRDD);

        sc.close();
    }
}
