package org.example.transformation.key_value;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
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

        /* combineByKey算子
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
        */

        /* reduceByKey算子
        JavaPairRDD<String,Integer> rdd = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3),
                new Tuple2<>("apple",10),
                new Tuple2<>("banana",7)
        ));
        JavaPairRDD<String,Integer> reducedRDD = rdd.reduceByKey((value1,value2) -> value1 + value2);
        List<Tuple2<String,Integer>> output = reducedRDD.collect();
        System.out.println(output);
        */

        /* repartition算子
        JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1,2,3,4,5));
        JavaRDD<Integer> repartitionRDD = rdd.repartition(3);
        JavaRDD<Integer> resultRDD = repartitionRDD.mapPartitions(iter -> {
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

        // cogroup算子
        JavaPairRDD<String,Integer> rdd1 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",5),
                new Tuple2<>("banana",3)
        ));
        JavaPairRDD<String,Double> rdd2 = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("apple",3.0),
                new Tuple2<>("banana",2.5)
        ));
        JavaPairRDD<String,Tuple2<Iterable<Integer>,Iterable<Double>>> cogroupRDD = rdd1.cogroup(rdd2);
        List<Tuple2<String,Tuple2<Iterable<Integer>,Iterable<Double>>>> output = cogroupRDD.collect();
        System.out.println(output);

        sc.close();
    }
}
