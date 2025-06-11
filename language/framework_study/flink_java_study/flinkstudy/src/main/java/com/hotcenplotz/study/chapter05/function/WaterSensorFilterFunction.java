package com.hotcenplotz.study.chapter05.function;

import com.hotcenplotz.study.chapter05.bean.WaterSensor;
import org.apache.flink.api.common.functions.FilterFunction;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-07 22:39
 * @description:
 */


public class WaterSensorFilterFunction implements FilterFunction<WaterSensor> {
    public String id;
    
    public WaterSensorFilterFunction(String id) {
        this.id = id;
    }
    
    @Override
    public boolean filter(WaterSensor value) throws Exception {
        return this.id.equals(value.getId());
    }
}
