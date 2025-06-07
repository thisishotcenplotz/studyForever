package com.hotcenplotz.chapter05.transform_;

import com.hotcenplotz.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 21:44
 * @description: transformation -> filter
 */


public class Demo03Flatmap_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        DataStreamSource<WaterSensor> fakeData = flink.fromData(
            new WaterSensor("s1", 1L, 10),
            new WaterSensor("s2", 2L, 11),
            new WaterSensor("s3", 3L, 12),
            new WaterSensor("s4", 5L, 13),
            new WaterSensor("s5", 5L, 13),
            new WaterSensor("s6", 6L, 13)
        );
        
        // flatMap 1
        SingleOutputStreamOperator<String> processed = fakeData.flatMap(new FlatMapFunction<WaterSensor, String>() {
            @Override
            public void flatMap(WaterSensor value, Collector<String> out) throws Exception {
                if ("s1".equals(value.getId())) {
                    out.collect(value.getVc().toString());
                } else if ("s2".equals(value.getId())) {
                    out.collect(value.getTs().toString() + " " + value.getVc().toString());
                } else {
                    out.collect("~~~~");
                }
            }
        });
        
        processed.print();
        
        flink.execute();
    }
    
    public static class MyFilterFunction implements FilterFunction<WaterSensor> {
        @Override
        public boolean filter(WaterSensor value) throws Exception {
            return "s3".equals(value.getId());
        }
    }
}
