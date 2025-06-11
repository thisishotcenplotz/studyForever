package com.hotcenplotz.study.chapter05.sink_;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.connector.source.util.ratelimit.RateLimiterStrategy;
import org.apache.flink.configuration.MemorySize;
import org.apache.flink.connector.datagen.source.DataGeneratorSource;
import org.apache.flink.connector.datagen.source.GeneratorFunction;
import org.apache.flink.connector.file.sink.FileSink;
import org.apache.flink.core.execution.CheckpointingMode;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.OutputFileConfig;
import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.DateTimeBucketAssigner;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;

import java.time.Duration;
import java.time.ZoneId;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 18:23
 * @description:
 */


public class Demo01File_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(3);
        flink.enableCheckpointing(1000, CheckpointingMode.EXACTLY_ONCE);

        // Data Gen Source
        DataGeneratorSource<String> fakeData = new DataGeneratorSource<>(
            new GeneratorFunction<Long, String>() {
                @Override
                public String map(Long value) throws Exception {
                    return "Number: " + value;
                }
            }
            , Long.MAX_VALUE
            , RateLimiterStrategy.perSecond(200)
            , Types.STRING
        );

        DataStreamSource<String> source = flink.fromSource(fakeData, WatermarkStrategy.noWatermarks(), "fake data gen");

        // TODO 输出到文件系统
        // file sink builder
        FileSink<String> fileSink = FileSink.<String>forRowFormat( // 指定文件路径，指定编码
            new Path("output")
            , new SimpleStringEncoder<String>()
        ).withOutputFileConfig( // 配置文件前缀和后缀
            OutputFileConfig.builder()
                .withPartPrefix("dataFakeGen_")
                .withPartSuffix(".log")
                .build()
        ).withBucketAssigner( // 按照目录分桶
            new DateTimeBucketAssigner<>("yyyy-MM-dd mm", ZoneId.systemDefault())
        ).withRollingPolicy( // 文件滚动策略： 10s 1M
            DefaultRollingPolicy.builder()
                .withInactivityInterval(Duration.ofSeconds(10))
                .withMaxPartSize(new MemorySize(1024 * 1024))
                .build()
        ).build();

        // sink
        source.sinkTo(fileSink);

        flink.execute();
    }
}
