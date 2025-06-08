package com.hotcenplotz.chapter05.combine_;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 16:50
 * @description:
 */


public class CombineDemo02Connect_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        
        // create two stream
        DataStreamSource<String> streamA = flink.socketTextStream("localhost", 10999);
        DataStreamSource<String> streamB = flink.socketTextStream("localhost", 20999);
        
        // using connect
        // 一次只能连接两条流
        // 两条流可以数据类型不一致。
        ConnectedStreams<String, String> connected = streamA.connect(streamB);
        connected.map(
            new CoMapFunction<String, String, Tuple2<String, Integer>>() {
                @Override
                public Tuple2<String, Integer> map1(String value) throws Exception {
                    return Tuple2.of(value, 1);
                }
                
                @Override
                public Tuple2<String, Integer> map2(String value) throws Exception {
                    return Tuple2.of(value, 1);
                }
            }
        ).keyBy(
            value -> value.f0
        )
        .sum(1)
        .print();
        
        flink.execute();
    }
}
