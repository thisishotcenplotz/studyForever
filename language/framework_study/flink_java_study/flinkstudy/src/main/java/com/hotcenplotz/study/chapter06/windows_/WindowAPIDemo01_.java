package com.hotcenplotz.study.chapter06.windows_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.GlobalWindows;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.evictors.CountEvictor;
import org.apache.flink.streaming.api.windowing.triggers.CountTrigger;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.sql.Time;
import java.time.Duration;
import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-12 07:24
 * @description:
 */


public class WindowAPIDemo01_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(3);
        
        DataStreamSource<String> socketSource = flink.socketTextStream("localhost", 7777);
        SingleOutputStreamOperator<WaterSensor> waterSensors = socketSource.flatMap(new FlatMapFunction<String, WaterSensor>() {
            @Override
            public void flatMap(String value, Collector<WaterSensor> out) throws Exception {
                for (String s : value.split("\\s+")) {
                    out.collect(new WaterSensor(
                        s + " " + new Random().nextInt(),
                        System.currentTimeMillis(),
                        new Random().nextInt()
                    ));
                }
            }
        });
        
        KeyedStream<WaterSensor, Integer> keyedWaterSensors = waterSensors.keyBy(new KeySelector<WaterSensor, Integer>() {
            @Override
            public Integer getKey(WaterSensor waterSensor) throws Exception {
                return waterSensor.getVc() % 5;
            }
        });
        
        // TODO 1： 指定窗口分配器
        // TODO 1.1: 没有keyBy; 窗口内的所有数据进行一个子任务，并行度只能为1；
        
        // 基于时间的
        //waterSensors.windowAll(TumblingProcessingTimeWindows.of(Duration.ofSeconds(10))); // 滚动窗口 10 秒
        //waterSensors.windowAll(SlidingProcessingTimeWindows.of(Duration.ofSeconds(10), Duration.ofSeconds(2))); // 窗口长度10秒，步长2秒
        //waterSensors.windowAll(ProcessingTimeSessionWindows.withGap(Duration.ofSeconds(10))); // 会话窗口 10 秒

        
        // TODO 1.2: 有keyBy; 每个key都定义了一组窗口，各自独立进行计算
        
        // 基于计数的
        // keyedWaterSensors.countWindow(5); // 基于数量 5 条
        // keyedWaterSensors.countWindow(5,2); // 窗口长度为5，滑动步长为2
        // keyedWaterSensors // 全局窗口 需要自定义
            //.window(GlobalWindows.create())
            //.evictor(CountEvictor.of(5))
            //.trigger(CountTrigger.of(5));
        
        //TODO 2： 指定窗口函数
        
        WindowedStream<WaterSensor, Integer, TimeWindow> window = keyedWaterSensors
            .window(TumblingProcessingTimeWindows.of(Duration.ofSeconds(5)));
        
        // 增量聚合：来一条数据，计算一条数据，窗口触发时候输出计算结果  reduce
   
        
        // 全窗口函数：数据来了不计算，存起来，窗口触发是哦户，计算并输出结果。 process
        
        
        flink.execute();
    }
}
