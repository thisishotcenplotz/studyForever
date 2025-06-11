package com.hotcenplotz.study.chapter05.sink_;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FlatMapFunction;


import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcStatementBuilder;
import org.apache.flink.connector.jdbc.core.datastream.sink.JdbcSink;
import org.apache.flink.connector.jdbc.core.datastream.sink.JdbcSinkBuilder;
import org.apache.flink.core.execution.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.apache.flink.util.Collector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        
        waterSensor.print();
        
        // 这才是flink2.0 写入mysql 的正确写法，官网的不对！！！
        // https://nightlies.apache.org/flink/flink-docs-release-2.0/docs/connectors/datastream/jdbc/
        JdbcSinkBuilder<WaterSensor> builder = JdbcSink.builder();
        
        JdbcSink<WaterSensor> waterSensorJdbcSink = builder.withQueryStatement(
            "insert into flink.watersensor(id,ts,vc) values(?,?,?)",
            new JdbcStatementBuilder<WaterSensor>() {
                @Override
                public void accept(PreparedStatement preparedStatement, WaterSensor waterSensor) throws SQLException {
                    preparedStatement.setString(1, waterSensor.getId());
                    preparedStatement.setLong(2, waterSensor.getTs());
                    preparedStatement.setInt(3, waterSensor.getVc());
                }
            }
        ).withExecutionOptions(
            JdbcExecutionOptions.builder()
                .withBatchIntervalMs(2000)
                .withBatchSize(500)
                .withMaxRetries(3)
                .build()
        ).buildAtLeastOnce(
            new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
                .withUrl("jdbc:mysql://localhost:3306/flink")
                .withDriverName("com.mysql.cj.jdbc.Driver")
                .withUsername("root")
                .withPassword("123456")
                .withConnectionCheckTimeoutSeconds(60)
                .build()
        );
        
        waterSensor.sinkTo(waterSensorJdbcSink);


        flink.execute();
    }
}
