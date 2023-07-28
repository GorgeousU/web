package org.example;

import org.apache.flink.api.java.aggregation.SumAggregationFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class Practice2 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        env.setParallelism(1);
        DataStream<Tuple2<String, Integer>> input = env.fromElements(
                Tuple2.of("A", 1),
                Tuple2.of("A", 2),
                Tuple2.of("A", 3),
                Tuple2.of("B", 4),
                Tuple2.of("B",5)
        );
        DataStream<Tuple2<String,Integer>> windowedStream = input
                .keyBy(tuple -> tuple.f0)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
                .sum(1)
                .name("Tumbling window");
        System.out.println("success");
        windowedStream.print().setParallelism(1);

        env.execute();
    }
}
