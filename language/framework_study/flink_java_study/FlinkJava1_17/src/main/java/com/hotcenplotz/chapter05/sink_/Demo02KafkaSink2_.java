package com.hotcenplotz.chapter05.sink_;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchemaBuilder;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.core.execution.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.annotation.Nullable;
import java.nio.charset.StandardCharsets;


/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 21:08
 * @description:
 */


public class Demo02KafkaSink2_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // 必须开启checkpoint，否则在精准一次 无法写入
//        flink.enableCheckpointing(1000, CheckpointingMode.EXACTLY_ONCE);
//        flink.setParallelism(1);
        
        DataStreamSource<String> waterSensor = flink.socketTextStream("localhost", 7777);
        
        KafkaSink<String> kafkaSink = KafkaSink.<String>builder()
            .setBootstrapServers("localhost:19092,localhost:29092,localhost:39092")
            .setRecordSerializer(
                new KafkaRecordSerializationSchema<String>() {
                    @Nullable
                    @Override
                    public ProducerRecord<byte[], byte[]> serialize(String element, KafkaSinkContext context, Long timestamp) {
                        String[] data = element.split(",");
                        byte[] key = data[0].getBytes(StandardCharsets.UTF_8);
                        byte[] value = element.getBytes(StandardCharsets.UTF_8);
                        
                        return new ProducerRecord<>("watersensor",key,value);
                    }
                }
            ).setDeliveryGuarantee(DeliveryGuarantee.AT_LEAST_ONCE)
            .build();

        waterSensor.sinkTo(kafkaSink);
        
        waterSensor.print();
        
        flink.execute();
    }
}
