package com.hotcenplotz.study.chapter02;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
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


/**
 * 1. Slot 特点：
 *  1) 均分隔离内存，不隔离cpu
 *  2) 可以共享：
 *       同一个job中，不同算子的子任务才可以共享同一个slot，同时在运行的
 *       前提是，属于同一个slot共享组，模式都是default
 * */


public class SharingSlotGroupWordCountStreamProcessDemo {
    public static void main(String[] args) throws Exception {
        // TODO 1. 创建执行环境
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        
        // TODO 2. 读取数据 socket
        DataStreamSource<String> socketData = flink.socketTextStream("hadoop101", 10999);
        
        // TODO 3. 处理数据: 切分 转tuple 聚合
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketData.flatMap((String value, Collector<String> out) -> {
                String[] words = value.split(" ");
                for (String word : words) {
                    out.collect(word);
                }
            }).returns(Types.STRING)
            .map(word -> Tuple2.of(word, 1))
            .slotSharingGroup("aaa") // 这时共享组就是aaa，默认是default，这样的话就无法和下面的keyBy共享了。
            .returns(Types.TUPLE(Types.STRING, Types.INT))
            .keyBy(value -> value.f0)
            .sum(1);
        
        
        // TODO 4. 输出
        result.print();
        
        // TODO 5. 执行
        flink.execute("socket word count demo");
    }
}

