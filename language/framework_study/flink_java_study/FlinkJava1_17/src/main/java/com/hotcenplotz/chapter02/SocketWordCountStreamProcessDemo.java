package com.hotcenplotz.chapter02;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-02 18:52
 * @description: 读Socket 实现无界流的word count
 */


public class SocketWordCountStreamProcessDemo {
    public static void main(String[] args) throws Exception {
        // TODO 1. 创建执行环境
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // TODO 2. 读取数据 socket
        DataStreamSource<String> socketData = flink.socketTextStream("localhost", 10999);
        
        // TODO 3. 处理数据: 切分 转tuple 聚合
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketData.flatMap(
                (String value, Collector<Tuple2<String, Integer>> out) -> {
                    String[] words = value.split(" ");
                    for (String word : words) {
                        out.collect(new Tuple2<>(word, 1));
                    }
                }
            ).returns(Types.TUPLE(Types.STRING, Types.INT))
            .keyBy(value -> value.f0)
            .sum(1);
        
        // TODO 4. 输出
        result.print();
        
        // TODO 5. 执行
        flink.execute("socket word count demo");
    }
}
