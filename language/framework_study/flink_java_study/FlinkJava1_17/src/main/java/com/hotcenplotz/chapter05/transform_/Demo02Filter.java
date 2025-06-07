package com.hotcenplotz.chapter05.transform_;

import com.hotcenplotz.chapter05.bean.WaterSensor;
import com.hotcenplotz.chapter05.function.WaterSensorFilterFunction;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 21:44
 * @description: transformation -> filter
 */


public class Demo02Filter {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        DataStreamSource<WaterSensor> fakeData = flink.fromData(
            new WaterSensor("s1", 1L, 10),
            new WaterSensor("s2", 2L, 11),
            new WaterSensor("s3", 3L, 12),
            new WaterSensor("s4", 5L, 13)
        );
        
        // filter 1
        SingleOutputStreamOperator<WaterSensor> filtered = fakeData.filter(new FilterFunction<WaterSensor>() {
            @Override
            public boolean filter(WaterSensor value) throws Exception {
                return "s1".equals(value.getId());
            }
        });
        
        // filter 2
        SingleOutputStreamOperator<WaterSensor> filtered1 = fakeData.filter(sensor -> "s2".equals(sensor.getId()));
        
        // filter 3
        SingleOutputStreamOperator<WaterSensor> filtered2 = fakeData.filter(new MyFilterFunction());
        
        // filter 4
        
        SingleOutputStreamOperator<WaterSensor> filtered3 = fakeData.filter(new WaterSensorFilterFunction("s4"));

        filtered3.print();
        
        flink.execute();
    }
    
    public static class MyFilterFunction implements FilterFunction<WaterSensor> {
        @Override
        public boolean filter(WaterSensor value) throws Exception {
            return "s3".equals(value.getId());
        }
    }
}
