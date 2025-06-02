package com.hotcenplotz.chapter02;


import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.reader.TextLineInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-02 18:06
 * @description: Word Count Streaming Process Demo
 */


public class WordCountStreamProcessDemo_ {
    public static void main(String[] args) throws Exception {
        // TODO 1. 创建执行环境
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // TODO 2. 读取数据
        FileSource<String> fileSource = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path("input/wordcount.txt")).build();
        
        DataStreamSource<String> dataSource = flink.fromSource(fileSource, WatermarkStrategy.noWatermarks(), "word count");
        
        // TODO 3. 处理数据
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = dataSource.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(
                String value, Collector<Tuple2<String, Integer>> out
            ) throws Exception {
                String[] words = value.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        out.collect(Tuple2.of(word, 1));
                    }
                }
            }
        }).keyBy(new KeySelector<Tuple2<String, Integer>, String>() {
            @Override
            public String getKey(Tuple2<String, Integer> value) throws Exception {
                return value.f0;
            }
        }).sum(1);
        
        // TODO 4. 输出数据
        result.print();
        
        // TODO 5. 执行
        flink.execute("Stream Process Habibi");
    }
}
