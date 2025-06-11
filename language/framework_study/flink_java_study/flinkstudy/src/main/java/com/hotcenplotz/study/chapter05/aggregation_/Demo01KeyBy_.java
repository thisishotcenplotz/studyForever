package com.hotcenplotz.study.chapter05.aggregation_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 22:09
 * @description:
 */


public class Demo01KeyBy_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        DataStreamSource<WaterSensor> fakeData = flink.fromData(
            new WaterSensor("s1", 1L, 10),
            new WaterSensor("s2", 2L, 11),
            new WaterSensor("s2", 3L, 12),
            new WaterSensor("s3", 5L, 13),
            new WaterSensor("s3", 5L, 13),
            new WaterSensor("s3", 6L, 13)
        );
        
        KeyedStream<WaterSensor, String> groupedSensor = fakeData.keyBy(new KeySelector<WaterSensor, String>() {
            @Override
            public String getKey(WaterSensor value) throws Exception {
                return value.getId();
            }
        });
        
        // TODO: sum min max maxBy
        // groupedSensor.sum("vc").print();
        // groupedSensor.min("vc").print();
        // groupedSensor.maxBy("vc").print();
        
        // TODO: reduce
        groupedSensor.reduce(new ReduceFunction<WaterSensor>() {
            @Override
            public WaterSensor reduce(WaterSensor value1, WaterSensor value2) throws Exception {
                return new WaterSensor(value2.id,value1.ts,value1.vc + value2.vc);
            }
        }).print();
        
        
        flink.execute();
    }
}
