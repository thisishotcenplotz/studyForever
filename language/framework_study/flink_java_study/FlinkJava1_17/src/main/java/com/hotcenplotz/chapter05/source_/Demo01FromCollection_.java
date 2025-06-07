package com.hotcenplotz.chapter05.source_;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 15:21
 * @description:
 */


public class Demo01FromCollection_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // TODO 从集合读取数据
        DataStreamSource<Integer> source = flink.fromData(Arrays.asList(1, 22, 3, 44, 5));

        source.print();
        
        flink.execute();
    }
}
