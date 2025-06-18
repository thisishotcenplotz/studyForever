package com.hotcenplotz.study.chapter06.watermark_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import com.hotcenplotz.study.chapter05.partition.MyPartitioner;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

import java.time.Duration;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-17 07:35
 * @description: subtask 空闲等待
 */


public class WatermarkDemo04Idleness_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        
        flink.setParallelism(2);
        
        // 自定义分区器，数据 % 分区数，只输入奇数，都只会去map的一个子任务，其他不会有数据。
        SingleOutputStreamOperator<String> processed = flink.socketTextStream("localhost", 7777)
            .partitionCustom(new MyPartitioner(), r -> r)
            .map(new MapFunction<String, Integer>() {
                @Override
                public Integer map(String value) throws Exception {
                    return Integer.parseInt(value);
                }
            }).assignTimestampsAndWatermarks(
                WatermarkStrategy.<Integer>forBoundedOutOfOrderness(Duration.ofSeconds(5))
                    .withTimestampAssigner(new SerializableTimestampAssigner<Integer>() {
                        @Override
                        public long extractTimestamp(Integer element, long recordTimestamp) {
                            return element * 1000L;
                        }
                    })
                    .withIdleness(Duration.ofSeconds(5)) // 设置空闲等待时间为5秒
            
            )
            
            // 分成2组；开10秒事件时间滚动窗口
            .keyBy(new KeySelector<Integer, Integer>() {
                @Override
                public Integer getKey(Integer integer) throws Exception {
                    return integer % 2;
                }
            }).window(
                TumblingProcessingTimeWindows.of(Duration.ofSeconds(10))
            ).allowedLateness(
                Duration.ofSeconds(2)
            ).sideOutputLateData( // 侧输出关窗后的迟到数据！
                new OutputTag<Integer>("late-data")
            ).process(new ProcessWindowFunction<Integer, String, Integer, TimeWindow>() {
                @Override
                public void process(Integer integer, ProcessWindowFunction<Integer, String, Integer, TimeWindow>.Context context, Iterable<Integer> elements, Collector<String> out) throws Exception {
                    String windowStart = DateFormatUtils.format(context.window().getStart(), "yyyy-MM-dd HH:mm:ss");
                    String windowEnd = DateFormatUtils.format(context.window().getEnd(), "yyyy-MM-dd HH:mm:ss");
                    
                    long size = elements.spliterator().estimateSize();
                    
                    out.collect("[key = " + integer + "] " + " -> [" + windowStart + "] -> [" + windowEnd + "] -> [" + size + "] -> " + elements.toString());
                }
            });
        
        processed.print();
        
        flink.execute("go !");
        
    }
}
