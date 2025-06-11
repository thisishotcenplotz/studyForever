package com.hotcenplotz.study.chapter05;

import org.apache.flink.api.common.RuntimeExecutionMode;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 12:19
 * @description:
 */


public class EnvDemo {
    public static void main(String[] args) throws Exception {
        
        // 本地环境, 一般在本地运行
        StreamExecutionEnvironment.createLocalEnvironment();
        
        // 远程
        StreamExecutionEnvironment.createRemoteEnvironment("hadoop101", 8081,"xxx.jar");
        
        
        // 一般这么调就行了
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setRuntimeMode(RuntimeExecutionMode.BATCH); // 设置为批处理模式。
        flink.setRuntimeMode(RuntimeExecutionMode.STREAMING); // 设置为流处理模式。
        
        // 执行
        flink.execute(); // 到这就阻塞了
        
        // 但是可以这么玩
        flink.executeAsync(); // 到这不阻塞
        // ....另一套flink代码
        flink.executeAsync();
        // 一共两套处理逻辑
        
        // 1. 默认flink.execute() 触发一个flink job
        // 2. flink.executeAsync() , 一个main方法里 executeAsync() 的个数，等于生成的flink job 个数
    }
}
