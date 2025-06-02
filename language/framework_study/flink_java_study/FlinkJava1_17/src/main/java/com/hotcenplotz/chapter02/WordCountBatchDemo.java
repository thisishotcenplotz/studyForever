package com.hotcenplotz.chapter02;


import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.reader.TextLineInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;

import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;


/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-02 14:59
 * @description: Flink 快速上手 -> Word Count
 */


public class WordCountBatchDemo {
    public static void main(String[] args) throws Exception {
        // TODO 1. Create Flink Execution Environment
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setRuntimeMode(RuntimeExecutionMode.BATCH);

        // TODO 2. Read Source File
        FileSource<String> dataSource = FileSource.forRecordStreamFormat(new TextLineInputFormat(), new Path("input/wordcount.txt")).build();
        DataStreamSource<String> sourceData = flink.fromSource(dataSource, WatermarkStrategy.noWatermarks(), "wordcount");

        // TODO 3. Data Segmentation and Transformation
        SingleOutputStreamOperator<Tuple2<String, Integer>> words = sourceData.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] tokens = value.toLowerCase().split("\\s+");
                for (String token : tokens) {
                    if(!token.isEmpty()) {
                        collector.collect(Tuple2.of(token, 1));
                    }
                }
            }
        });


        // TODO 4. Grouping Data
        KeyedStream<Tuple2<String, Integer>, String> groupedData = words.keyBy(val -> val.f0);


        // TODO 5. Aggregate
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = groupedData.sum(1); // 这里的1 是位置，表示第二个元素

        // TODO 6. Output
        result.print();

        // TODO 7. Execution
        flink.execute("Word Count Batch Demo");


    }
}
