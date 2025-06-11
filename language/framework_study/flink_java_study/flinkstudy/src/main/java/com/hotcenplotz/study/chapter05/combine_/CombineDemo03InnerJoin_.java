package com.hotcenplotz.study.chapter05.combine_;


import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 17:07
 * @description: 根据ID匹配，类似inner join
 */


public class CombineDemo03InnerJoin_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        
        // create two stream
        DataStreamSource<Tuple2<Integer, String>> dataA = flink.fromData(
            Tuple2.of(1, "a1"),
            Tuple2.of(1, "a2"),
            Tuple2.of(2, "b"),
            Tuple2.of(3, "c")
        );
        
        DataStreamSource<Tuple3<Integer, String, Integer>> dataB = flink.fromData(
            Tuple3.of(1, "aa1", 1),
            Tuple3.of(1, "aa2", 2),
            Tuple3.of(2, "bb", 1),
            Tuple3.of(3, "cc", 1)
        );
        
        // combine two stream
        ConnectedStreams<Tuple2<Integer, String>, Tuple3<Integer, String, Integer>> connected = dataA.connect(dataB);
        
        // keyBy: 多并行度下，需要根据关联条件进行keyBy, 才能保证key的相同数据去到一个分组，这样才能匹配上
        ConnectedStreams<Tuple2<Integer, String>, Tuple3<Integer, String, Integer>> keyByConnected = connected.keyBy(s1 -> s1.f0, s2 -> s2.f0);
        
        // 实现inner join 的效果
        /*
         * 1. 两条流，不一定谁的数据先来
         * 2. 每条流，有数据来的时候，先存到一个变量中 HashMap
         * 3. 每条流有数据来的时候，。除了存变量，不知道对方是否有匹配的数据，所以要去另一条流储存的数据中匹配一下。
         * */
        SingleOutputStreamOperator<String> processed = keyByConnected.process(
            new CoProcessFunction<Tuple2<Integer, String>, Tuple3<Integer, String, Integer>, String>() {
                // 定义HashMap 用来存数据
                Map<Integer, List<Tuple2<Integer, String>>> s1Catch = new HashMap<>();
                Map<Integer, List<Tuple3<Integer, String, Integer>>> s2Catch = new HashMap<>();
                
                // 第一条流的处理逻辑
                @Override
                public void processElement1(Tuple2<Integer, String> value, CoProcessFunction<Tuple2<Integer, String>, Tuple3<Integer, String, Integer>, String>.Context ctx, Collector<String> out) throws Exception {
                    Integer id = value.f0;
                    // s1 来的数据，先存到一个变量中
                    if (!s1Catch.containsKey(id)) {
                        ArrayList<Tuple2<Integer, String>> s1Values = new ArrayList<>();
                        s1Values.add(value);
                        s1Catch.put(id, s1Values);
                    } else {
                        s1Catch.get(id).add(value);
                    }
                    
                    // 去s2 catch 中是否有id可以匹配上
                    if (s2Catch.containsKey(id)) {
                        for (Tuple3<Integer, String, Integer> s2Element : s2Catch.get(id)) {
                            out.collect("s1: " + value + " <=====> " + " s2:" + s2Element);
                        }
                    }
                }
                
                // 第二条流的处理罗炯
                @Override
                public void processElement2(Tuple3<Integer, String, Integer> value, CoProcessFunction<Tuple2<Integer, String>, Tuple3<Integer, String, Integer>, String>.Context ctx, Collector<String> out) throws Exception {
                    Integer id = value.f0;
                    if (!s2Catch.containsKey(id)) {
                        ArrayList<Tuple3<Integer, String, Integer>> s2Values = new ArrayList<>();
                        s2Values.add(value);
                        s2Catch.put(id, s2Values);
                    } else {
                        s2Catch.get(id).add(value);
                    }
                    
                    if (s1Catch.containsKey(id)) {
                        for (Tuple2<Integer, String> s1Element : s1Catch.get(id)) {
                            out.collect("s2: " + value + " <=====> " + " s1:" + s1Element);
                        }
                    }
                }
            }
        );
        
        processed.print();
        
        flink.execute();
    }
}
