package com.hotcenplotz.study.chapter06.watermark_;

import org.apache.flink.api.common.eventtime.Watermark;
import org.apache.flink.api.common.eventtime.WatermarkGenerator;
import org.apache.flink.api.common.eventtime.WatermarkOutput;


/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-18 07:06
 * @description:
 */


public class MyPeriodicWatermarkGenerator<T> implements WatermarkGenerator<T> {
    
    // 乱序等待时间
    private long delayTs;
    
    // 用来保存当前最大事件时间
    private long maxTs;
    
    public MyPeriodicWatermarkGenerator(long delayTs) {
        this.delayTs = delayTs;
        this.maxTs = Long.MIN_VALUE + delayTs + 1;
    }
    
    /**
     * 每条数据来都会调用一次；用来提取最大的事件时间，并保存下来
     *
     * @param event
     * @param eventTimestamp 提取到的数据的事件时间
     * @param output
     */
    @Override
    public void onEvent(T event, long eventTimestamp, WatermarkOutput output) {
        maxTs = Math.max(maxTs, eventTimestamp);
        System.out.println("calling ofEvent() ... current max event timestamp is " + maxTs);
    }
    
    
    /**
     * 周期性调用；用来发射watermark
     *
     * @param output
     */
    @Override
    public void onPeriodicEmit(WatermarkOutput output) {
        output.emitWatermark(new Watermark(maxTs - delayTs - 1));
        System.out.println("calling onPeriodicEmit() ... current watermark is " + (maxTs - delayTs - 1));
    }
}
