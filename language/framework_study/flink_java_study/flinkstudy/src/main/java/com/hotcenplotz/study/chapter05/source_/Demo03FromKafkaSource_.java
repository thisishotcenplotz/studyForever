package com.hotcenplotz.study.chapter05.source_;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 16:51
 * @description:
 */


//<dependency>
//    <groupId>org.apache.flink</groupId>
//    <artifactId>flink-connector-kafka</artifactId>
//    <version>4.0.0-2.0</version>
//</dependency>

// --topic flinkdemo --partitions 3 --replication-factor 3
public class Demo03FromKafkaSource_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // TODO 1. create kafka source
        KafkaSource<String> kafkaSource = KafkaSource.<String>builder()
            .setBootstrapServers("localhost:19092,localhost:29092,localhost:39092").setTopics("flinkdemo")
            .setGroupId("flink").setValueOnlyDeserializer(new SimpleStringSchema())
            .setStartingOffsets(OffsetsInitializer.earliest()).build();
        
        DataStreamSource<String> kafkaSourceDemo = flink
            .fromSource(
                kafkaSource,
                WatermarkStrategy.noWatermarks(),
                "kafka source demo"
            );
        
        SingleOutputStreamOperator<Tuple2<String, Integer>> result = kafkaSourceDemo
            .flatMap(
                new FlatMapFunction<String, Tuple2<String, Integer>>() {
                    @Override
                    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                        String[] words = value.split("\\s+");
                        for (String word : words) {
                            out.collect(Tuple2.of(word, 1));
                        }
                    }
                }
            ).returns(
                Types.TUPLE(Types.STRING, Types.INT)
            ).keyBy(
                value -> value.f0
            ).sum(1);
        
        
        result.print();
        
        flink.execute();
    }
}
