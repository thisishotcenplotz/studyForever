package com.hotcenplotz.study.chapter05.split;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 11:12
 * @description: 分流
 */


public class DemoSplit {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        DataStreamSource<String> source = flink.socketTextStream("localhost", 10999);
        
        // TODO：分流 -> 基于filter实现效果
        //  缺点：同一份数据要被处理两次（调用了两次filter）性能差 不推荐使用
        SingleOutputStreamOperator<String> evenStream = source.filter(value -> Integer.parseInt(value) % 2 == 0);
        SingleOutputStreamOperator<String> oddStream = source.filter(value -> Integer.parseInt(value) % 2 == 1);
        
        evenStream.print("evenStream");
        oddStream.print("oddStream");
        flink.execute("split demo");
    }
}
