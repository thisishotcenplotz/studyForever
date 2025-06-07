package com.hotcenplotz.chapter05.transform_;

import org.apache.flink.api.common.functions.OpenContext;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 22:43
 * @description:
 */


public class Demo04RichFunction_ {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(1);
        
        DataStreamSource<Integer> fakeData = flink.fromData(1,2,3,4);
        
        // TODO: rich function
        fakeData.map(
            new RichMapFunction<Integer, Integer>() {
                
                @Override
                public Integer map(Integer value) throws Exception {
                    return value + 1;
                }
                
                @Override
                public void open(OpenContext openContext) throws Exception {
                    super.open(openContext);
                    RuntimeContext runtimeContext = getRuntimeContext();
                    String taskName = runtimeContext.getTaskInfo().getTaskName();
                    System.out.println("taskName: " + taskName + " " + runtimeContext.getTaskInfo().getTaskNameWithSubtasks());
                }
                
                @Override
                public void close() throws Exception {
                    super.close();
                    System.out.println("Done~~~");
                }
            }
        ).print();
        
        
        flink.execute();
    }
}
