package com.hotcenplotz.study.chapter06.windows_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-12 07:24
 * @description:
 */


public class WindowAPIDemo04AggregateAndProcess_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
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
        
        // aggregate and process
        SingleOutputStreamOperator<String> result = window.aggregate(new MyAgg(), new MyProcess());
        result.print();
        
        flink.execute();
    }
    
    public static class MyAgg implements AggregateFunction<WaterSensor, Integer, String> {
        @Override
        public Integer createAccumulator() {
            return 0;
        }
        
        @Override
        public Integer add(WaterSensor waterSensor, Integer integer) {
            return integer + waterSensor.getVc();
        }
        
        @Override
        public String getResult(Integer integer) {
            String now = DateFormatUtils.format(new Date().getTime(), "yyyy-MM-dd HH:mm:ss");
            return "["+now+"] -> " + integer;
        }
        
        @Override
        public Integer merge(Integer integer, Integer acc1) {
            return null;
        }
    }
    
    public static class MyProcess extends ProcessWindowFunction<String, String, Integer, TimeWindow> {
        @Override
        public void process(Integer integer, ProcessWindowFunction<String, String, Integer, TimeWindow>.Context context, Iterable<String> elements, Collector<String> out) throws Exception {
            String windowStart = DateFormatUtils.format(context.window().getStart(), "yyyy-MM-dd HH:mm:ss");
            String windowEnd = DateFormatUtils.format(context.window().getEnd(), "yyyy-MM-dd HH:mm:ss");
            
            long size = elements.spliterator().estimateSize();
            out.collect("["+windowStart + "] -> [" + windowEnd + "] -> [" + size + "] -> " + elements.toString());
            
        }
    }
}
