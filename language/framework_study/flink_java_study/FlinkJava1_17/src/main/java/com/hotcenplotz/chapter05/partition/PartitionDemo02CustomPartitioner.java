package com.hotcenplotz.chapter05.partition;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 09:32
 * @description: Partition Demo
 */


public class PartitionDemo02CustomPartitioner {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        DataStreamSource<String> source = flink.socketTextStream("localhost", 10999);
        
        // TODO 自定义分区器
        source.partitionCustom(new MyPartitioner(), new KeySelector<String, String>() {
            @Override
            public String getKey(String value) throws Exception {
                return value;
            }
        }).print();
        
        flink.execute();
        
    }
}
