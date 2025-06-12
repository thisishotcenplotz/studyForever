package com.hotcenplotz.study.chapter06.windows_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.AggregateFunction;
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
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-12 07:24
 * @description:
 */


public class WindowAPIDemo02Aggregation_ {
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
        
        // 窗口函数：增量聚合 Aggregate
        SingleOutputStreamOperator<WaterSensor> aggregated = window.aggregate(
            new AggregateFunction<WaterSensor, Integer, WaterSensor>() {
                /**
                 * param1: 输入类型
                 * param2: 累加器类型
                 * param3: 输出类型
                 * */
                @Override
                public Integer createAccumulator() {
                    System.out.println("Initialize accumulator");
                    return 0;
                }
                
                /* 聚合逻辑 */
                @Override
                public Integer add(WaterSensor waterSensor, Integer integer) {
                    System.out.println("update accumulator -> " + "Value = " + waterSensor.getVc());
                    return integer + waterSensor.getVc();
                }
                
                /* 当窗口触发时 获取计算结果*/
                @Override
                public WaterSensor getResult(Integer integer) {
                    System.out.println("call get result");
                    return new WaterSensor(
                        LocalDateTime.now().toString(),
                        System.currentTimeMillis(),
                        integer
                    );
                }
                
                /* 这个方法只有 Session Window 才会用到 */
                @Override
                public Integer merge(Integer integer, Integer acc1) {
                    System.out.println("call merge");
                    return 0;
                }
            }
        );
        
        aggregated.print();
        
        flink.execute();
    }
}
