package com.hotcenplotz.chapter02;

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
 * 1. 算子之间的传输关系：
 * - one to one
 * - 重分区
 * 2. 算子串在一起的条件
 * - 一对一
 * - 并行度相同
 * 3. 关于算子连：
 * - 全局禁用算子连 flink.disableOperatorChaining()
 * - 某个算子不参与链化 算子.disableChaining()
 * - 从某个算子开启新的链条： 算子.startNewChain()  算子不与前面串行在一起，从A开始正常
 * */


public class OperatorChainWordCountStreamProcessDemo {
    public static void main(String[] args) throws Exception {
        // TODO 1. 创建执行环境
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        flink.setParallelism(1);
        // flink.disableOperatorChaining();
        
        // TODO 2. 读取数据 socket
        DataStreamSource<String> socketData = flink.socketTextStream("hadoop101", 10999);
        
        // TODO 3. 处理数据: 切分 转tuple 聚合
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = socketData.flatMap((String value, Collector<String> out) -> {
                String[] words = value.split(" ");
                for (String word : words) {
                    out.collect(word);
                }
            }).returns(Types.STRING)
            // .startNewChain()
            .disableChaining()
            .map(word -> Tuple2.of(word, 1))
            .returns(Types.TUPLE(Types.STRING, Types.INT))
            .startNewChain()
            .keyBy(value -> value.f0)
            .sum(1);
        
        
        // TODO 4. 输出
        result.print();
        
        // TODO 5. 执行
        flink.execute("socket word count demo");
    }
}

