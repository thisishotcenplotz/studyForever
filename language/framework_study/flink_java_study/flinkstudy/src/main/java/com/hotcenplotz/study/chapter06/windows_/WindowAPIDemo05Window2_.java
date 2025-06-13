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
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
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


public class WindowAPIDemo05Window2_ {
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
        
        WindowedStream<WaterSensor, Integer, GlobalWindow> countWindow = keyedWaterSensors
//            .countWindow(5); // 计数的滚动窗口
            .countWindow(5,2); // 滑动窗口 长度5 步长2 (每经过一个步长都有一个窗口触发，第一次输出是在第二条来的时候)
        
        // aggregate and process
        SingleOutputStreamOperator<String> result = countWindow.aggregate(new MyAgg(), new MyCountProcess());
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
    
    public static class MyCountProcess extends ProcessWindowFunction<String, String, Integer, GlobalWindow> {
        @Override
        public void process(Integer integer, ProcessWindowFunction<String, String, Integer, GlobalWindow>.Context context, Iterable<String> elements, Collector<String> out) throws Exception {
            String windowStart = DateFormatUtils.format(context.window().maxTimestamp(), "yyyy-MM-dd HH:mm:ss");
            String windowEnd = DateFormatUtils.format(context.window().maxTimestamp(), "yyyy-MM-dd HH:mm:ss");
            
            long size = elements.spliterator().estimateSize();
            out.collect("["+windowStart + "] -> [" + windowEnd + "] -> [" + size + "] -> " + elements.toString());
            
        }
    }
}
