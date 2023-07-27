package org.example;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

import javax.xml.crypto.Data;

public class Practice1 {
    public static void main(String[] args) throws Exception {
        //创建流处理环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        /* Map算子
        //创建数据流
        DataStream<Integer> input = env.fromElements(1,2,3,4,5);
        //使用Map算子进行转换
        DataStream<Integer> result = input.map(value -> value * 2);
        //打印结果
        result.print();
         */

        /* flatmap算子
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
        DataStream<Tuple2<String,Integer>> result = input.keyBy(value -> value.f0);
        result.print();
        */

        DataStream<Tuple2<String,Integer>> input = env.fromElements(
                Tuple2.of("A",1),
                Tuple2.of("B",2),
                Tuple2.of("A",3),
                Tuple2.of("B",4)
        );
        DataStream<Tuple2<String,Integer>> result = input
                .keyBy(val -> val.f0)
                .reduce((val1,val2) -> Tuple2.of(val1.f0,val1.f1 + val2.f1));
        result.print();

        //执行作业
        env.execute("Flink");
    }
}