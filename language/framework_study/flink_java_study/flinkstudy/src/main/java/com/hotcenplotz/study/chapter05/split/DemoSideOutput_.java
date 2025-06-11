package com.hotcenplotz.study.chapter05.split;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 11:23
 * @description:
 */


public class DemoSideOutput_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        DataStreamSource<String> source = flink.socketTextStream("localhost", 10999);
        
        SingleOutputStreamOperator<WaterSensor> process = source.flatMap(
            new FlatMapFunction<String, WaterSensor>() {
                @Override
                public void flatMap(String value, Collector<WaterSensor> out) throws Exception {
                    String[] sensor = value.split(" ");
                    for (String s : sensor) {
                        out.collect(new WaterSensor("s" + s, System.currentTimeMillis(), new Random().nextInt()));
                    }
                }
            }
        ).process(
            new ProcessFunction<WaterSensor, WaterSensor>() {
                @Override
                public void processElement(WaterSensor value, ProcessFunction<WaterSensor, WaterSensor>.Context ctx, Collector<WaterSensor> out) throws Exception {
                    String id = value.getId();
                    if ("s1".equals(id)) {
                        OutputTag<WaterSensor> s1Tag = new OutputTag<>("s1 stream", Types.POJO(WaterSensor.class));
                        ctx.output(s1Tag, value);
                    } else if ("s2".equals(id)) {
                        OutputTag<WaterSensor> s2Tag = new OutputTag<>("s2 stream", Types.POJO(WaterSensor.class));
                        ctx.output(s2Tag, value);
                    } else {
                        out.collect(value);
                    }
                }
            }
        );
        
        process.print("主输出流");
        process.getSideOutput(new OutputTag<WaterSensor>("s1 stream", Types.POJO(WaterSensor.class))).print("S1 输出流");
        process.getSideOutput(new OutputTag<WaterSensor>("s2 stream", Types.POJO(WaterSensor.class))).print("S2 输出流");
        
        // TODO: 使用侧输出流
        //  需求：WaterSensor的数据，分开S1和S2
        
        flink.execute("Side Output Demo");
    }
}
