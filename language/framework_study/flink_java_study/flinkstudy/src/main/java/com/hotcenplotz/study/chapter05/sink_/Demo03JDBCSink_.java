package com.hotcenplotz.study.chapter05.sink_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FlatMapFunction;

import org.apache.flink.api.connector.sink2.Committer;
import org.apache.flink.api.connector.sink2.SinkWriter;
import org.apache.flink.connector.base.DeliveryGuarantee;
import org.apache.flink.connector.jdbc.*;
import org.apache.flink.connector.jdbc.core.datastream.Jdbc;
import org.apache.flink.connector.jdbc.core.datastream.sink.JdbcSinkBuilder;
import org.apache.flink.connector.jdbc.core.datastream.sink.committer.JdbcCommitable;
import org.apache.flink.connector.jdbc.datasource.connections.SimpleJdbcConnectionProvider;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.legacy.SinkFunction;
import org.apache.flink.streaming.api.operators.collect.CollectSinkFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.Preconditions;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-10 21:04
 * @description: sink to mysql...
 */


public class Demo03JDBCSink_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(3);

        DataStreamSource<String> source = flink.socketTextStream("localhost", 7777);

        SingleOutputStreamOperator<WaterSensor> waterSensor = source.flatMap(new FlatMapFunction<String, WaterSensor>() {
            @Override
            public void flatMap(String value, Collector<WaterSensor> out) throws Exception {
                for (String s : value.split("\\s+")) {
                    out.collect(new WaterSensor(
                        "s" + s + UUID.randomUUID().toString(),
                        System.currentTimeMillis(),
                        new Random().nextInt(100000)
                    ));
                }
            }
        });
        


//        flink.execute();
    }
}
