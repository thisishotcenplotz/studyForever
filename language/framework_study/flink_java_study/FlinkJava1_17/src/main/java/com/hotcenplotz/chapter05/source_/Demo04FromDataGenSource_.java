package com.hotcenplotz.chapter05.source_;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.connector.source.util.ratelimit.RateLimiterStrategy;
import org.apache.flink.connector.datagen.source.DataGeneratorSource;
import org.apache.flink.connector.datagen.source.GeneratorFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;


/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 18:07
 * @description:
 */


public class Demo04FromDataGenSource_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        // Data Gen Source
        DataGeneratorSource<String> fakeData = new DataGeneratorSource<>(
            new GeneratorFunction<Long, String>() {
                @Override
                public String map(Long value) throws Exception {
                    return "Number: " + value;
                }
            }
            , Long.MAX_VALUE
            , RateLimiterStrategy.perSecond(10)
            , Types.STRING
        );
        
        DataStreamSource<String> data = flink
            .fromSource(
                fakeData
                , WatermarkStrategy.noWatermarks(),
                "from data generator"
            );
        
        data.print();
        
        flink.execute();
    }
}
