package org.example;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

import javax.xml.crypto.Data;

public class Practice1 {
    public static void main(String[] args) throws Exception {
        //创建流处理环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        /* Map算子
        //设置并行度为1，即1个线程执行，以便观察
        env.setParallelism(1);
        //创建数据流
        DataStream<Integer> input = env.fromElements(1,2,3,4,5);
        //使用Map算子进行转换
        DataStream<Integer> result = input.map(value -> value * 2);
        //打印结果
        result.print();
        */


        /* flatmap算子
        env.setParallelism(1);
        DataStream<String> input = env.fromElements("Hello Flink","Welcome to Flink");
        DataStream<String> result = input.flatMap((String value, Collector<String> out) -> {
            for (String word : value.split(" ")) {
                out.collect(word);
            }
        }).returns(TypeInformation.of(String.class));
        result.print();
        */


        /* keyBy算子
        DataStream<Tuple2<String,Integer>> input = env.fromElements(
                Tuple2.of("apple",1),
                Tuple2.of("banana",2),
                Tuple2.of("orange",3),
                Tuple2.of("apple",4),
                Tuple2.of("banana",5)
        );
        KeyedStream<Tuple2<String,Integer>,String> result = input.keyBy(value -> value.f0);
        result.print();
        */


        /* filter算子
        env.setParallelism(1);
        DataStream<Integer> input = env.fromElements(1,2,3,4,5);
        DataStream<Integer> filteredStream = input.filter(num -> num % 2 == 0);
        filteredStream.print();
        */


        /* reduce算子
        env.setParallelism(1);
        DataStream<Tuple2<String, Integer>> input = env.fromElements(
                Tuple2.of("A", 1),
                Tuple2.of("B", 2),
                Tuple2.of("A", 3),
                Tuple2.of("B", 4)
        );
        DataStream<Tuple2<String, Integer>> result = input
                .keyBy(tuple -> tuple.f0)    //以第一个元组字段进行分组
                .reduce((val1, val2) -> Tuple2.of(val1.f0, val1.f1 + val2.f1));   //元组的第二个字段聚合
        result.print();
        */



        // max算子
        env.setParallelism(1);
        DataStream<Tuple2<String, Integer>> input = env.fromElements(
                Tuple2.of("A", 10),
                Tuple2.of("B", 20),
                Tuple2.of("C", 5),
                Tuple2.of("A", 15),
                Tuple2.of("B", 25),
                Tuple2.of("C", 7)
        );
        DataStream<Tuple2<String,Integer>> maxStream = input
                .keyBy(tuple -> tuple.f0)
                .maxBy(1);
        maxStream.print();


        /*
        DataStream<Tuple2<String, Integer>> input = env.fromElements(
                Tuple2.of("A", 10),
                Tuple2.of("B", 20),
                Tuple2.of("C", 5),
                Tuple2.of("A", 15),
                Tuple2.of("B", 25),
                Tuple2.of("C", 7)
        );
        KeyedStream<Tuple2<String,Integer>,String> keyedStream = input.keyBy(tuple -> tuple.f0);
        DataStream<Tuple2<String,Integer>> maxStream = keyedStream
                .sum(1);
        maxStream.print();
        */


        //执行作业
        env.execute("Flink");
    }
}