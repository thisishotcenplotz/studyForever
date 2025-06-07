package com.hotcenplotz.chapter05.transform_;

import com.hotcenplotz.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 21:44
 * @description: Transformation in flink -> map
 */


public class Demo01Map {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        // fake data
        DataStreamSource<WaterSensor> fakeData = flink.fromData(
            new WaterSensor("s1", 1L, 10),
            new WaterSensor("s2", 2L, 11),
            new WaterSensor("s3", 3L, 12)
        );
        
        // map method 1
        SingleOutputStreamOperator<String> sensorId = fakeData.map(
            new MapFunction<WaterSensor, String>() {
                @Override
                public String map(WaterSensor value) throws Exception {
                    return value.id;
                }
            }
        );
        
        // map method 2
        SingleOutputStreamOperator<String> sensorId2 = fakeData.map(sensor -> sensor.id);
        
        // map method 3
        SingleOutputStreamOperator<String> sensorId3 = fakeData.map(new MyMapFunction());
        
        sensorId3.print();
        
        // sensorId2.print();
        
        // sensorId.print();
        
        flink.execute();
        
    }
    
    public static class MyMapFunction implements MapFunction<WaterSensor, String> {
        @Override
        public String map(WaterSensor value) throws Exception {
            return value.id + " my map ~";
        }
    }
}
