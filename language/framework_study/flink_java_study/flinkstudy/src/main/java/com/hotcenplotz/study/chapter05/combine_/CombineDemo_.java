package com.hotcenplotz.study.chapter05.combine_;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 11:52
 * @description:
 */


public class CombineDemo_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        
        // create two stream
        DataStreamSource<String> streamA = flink.socketTextStream("localhost", 10999);
        DataStreamSource<String> streamB = flink.socketTextStream("localhost", 20999);
        
        // union
        // union 的数据类型必须一致。
        streamA.union(streamB).flatMap(new MyUnionFlatMapFunction()).keyBy(value -> value.f0).sum(1).print();
        
        flink.execute();
    }
    
    public static class MyUnionFlatMapFunction implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
            String[] split = value.split("\\s+");
            for (String s : split) {
                out.collect(Tuple2.of(s, 1));
            }
        }
    }
}
