package com.hotcenplotz.study.chapter06.windows_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.time.Duration;
import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-12 07:24
 * @description:
 */


public class WindowAPIDemo01Reduce_ {
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
        
        WindowedStream<WaterSensor, Integer, TimeWindow> window = keyedWaterSensors
            .window(TumblingProcessingTimeWindows.of(Duration.ofSeconds(5)));
        
        // 增量聚合：来一条数据，计算一条数据，窗口触发时候输出计算结果  reduce
        SingleOutputStreamOperator<WaterSensor> reduced = window.reduce(new ReduceFunction<WaterSensor>() {
            
            // 有一条数据作为初始值waterSensor 并不会被输出，只会输出剩下的。
            @Override
            public WaterSensor reduce(WaterSensor waterSensor, WaterSensor t1) throws Exception {
                System.out.println("call reduce ..." + waterSensor.getId() + " " + waterSensor.getVc() + " " + waterSensor.getTs());
                return new WaterSensor(
                    t1.getId(), t1.getTs(),
                    (waterSensor.getVc() + t1.getVc()) / 2
                );
            }
        });
        
        reduced.print();
        
        // 全窗口函数：数据来了不计算，存起来，窗口触发是哦户，计算并输出结果。 process
        
        
        flink.execute();
    }
}
