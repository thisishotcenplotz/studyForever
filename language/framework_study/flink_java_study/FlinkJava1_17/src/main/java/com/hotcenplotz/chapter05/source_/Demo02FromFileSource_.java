package com.hotcenplotz.chapter05.source_;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.file.src.FileSource;
import org.apache.flink.connector.file.src.reader.TextLineInputFormat;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 15:28
 * @description:
 */


public class Demo02FromFileSource_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        
        // TODO from file source
        // TODO 1. 先导入依赖
        //<dependency>
        //    <groupId>org.apache.flink</groupId>
        //    <artifactId>flink-connector-files</artifactId>
        //    <version>2.0.0</version>
        //</dependency>
        // TODO 2. 创建文件源
        FileSource<String> fileSource = FileSource.forRecordStreamFormat(
            new TextLineInputFormat(),
            new Path("input/wordcount.txt")
        ).build();
        
        // TODO 3. 读文件
        DataStreamSource<String> readData = flink.fromSource(fileSource, WatermarkStrategy.noWatermarks(), "read data from file");
        
        readData.print();
        
        flink.execute();
    }
}
