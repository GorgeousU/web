package org.example.practice;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class PiCalculation {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Pi Calculation").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        //设置迭代次数
        int numIterations = 100000;

        //生成数字序列
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numIterations; i++) {
            numbers.add(i);
        }
        JavaRDD<Integer> numbersRDD = sc.parallelize(numbers);

        //根据莱布尼茨公式计算圆周率
        double pi = 4.0 * numbersRDD.mapToDouble(i -> {
            double numerator = (i % 2 == 0 ) ? 1.0 : -1.0;
            double denominator = i * 2 + 1;
            return numerator/denominator;
        }).sum();

        System.out.println("Pi is approximately: " + pi);

        sc.close();
    }
}
