package com.hotcenplotz.study.chapter06.watermark_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.flink.api.common.eventtime.*;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.time.Duration;
import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-17 07:35
 * @description: 有序自增watermark
 */


public class WatermarkDemo03Custom_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        flink.setParallelism(1);
        
        // 默认周期200ms : 调用watermark的周期;
        // 平时最好别改
        // 这次改大纯为展示
        flink.getConfig().setAutoWatermarkInterval(2000);
        
        SingleOutputStreamOperator<WaterSensor> mapedWatersensor = flink.socketTextStream("localhost", 7777)
            .map(new MapFunction<String, WaterSensor>() {
                @Override
                public WaterSensor map(String value) throws Exception {
                    return new WaterSensor(value.strip()
                        .toLowerCase(), System.currentTimeMillis(), new Random().nextInt());
                }
            });
        
        // TODO 定义watermark 策略
        WatermarkStrategy<WaterSensor> waterSensorWatermarkStrategy = WatermarkStrategy
            // 自定义 watermark
            .<WaterSensor>forGenerator(
                new WatermarkGeneratorSupplier<WaterSensor>() {
                    @Override
                    public WatermarkGenerator<WaterSensor> createWatermarkGenerator(Context context) {
//                        return new MyPeriodicWatermarkGenerator<>(3000L); // 自定义周期watermark
                        return new MyPuntuaedWatermarkGenerator<>(3000); // 自定义断点watermark
                    }
                }
            )
            // 指定时间戳分配器，从数据中提取事件时间。
            .withTimestampAssigner(new SerializableTimestampAssigner<WaterSensor>() {
                @Override
                public long extractTimestamp(WaterSensor element, long recordTimestamp) {
                    System.out.println("   ---> <" + recordTimestamp + ">" + "   " + element.getTs().toString());
                    // convert millisecond to second
                    return element.getTs() * 1000L;
                }
            });
        
        // TODO 指定watermark
        SingleOutputStreamOperator<WaterSensor> watersensorWithWatermark = mapedWatersensor.assignTimestampsAndWatermarks(waterSensorWatermarkStrategy);
        
        watersensorWithWatermark.keyBy(new KeySelector<WaterSensor, String>() {
                @Override
                public String getKey(WaterSensor waterSensor) throws Exception {
                    return waterSensor.getId();
                }
            }).window(
                TumblingProcessingTimeWindows.of(Duration.ofSeconds(10))
            ).process(new ProcessWindowFunction<WaterSensor, String, String, TimeWindow>() {
                @Override
                public void process(String s, ProcessWindowFunction<WaterSensor, String, String, TimeWindow>.Context context, Iterable<WaterSensor> elements, Collector<String> out) throws Exception {
                    String windowStart = DateFormatUtils.format(context.window().getStart(), "yyyy-MM-dd HH:mm:ss");
                    String windowEnd = DateFormatUtils.format(context.window().getEnd(), "yyyy-MM-dd HH:mm:ss");
                    
                    long size = elements.spliterator().estimateSize();
                    out.collect("[" + windowStart + "] -> [" + windowEnd + "] -> [" + size + "] -> " + elements.toString());
                    
                }
            }).print();
        
        flink.execute("waterMark Demo..");
        
    }
}
