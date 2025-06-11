package com.hotcenplotz.study.chapter05.partition;

import org.apache.flink.api.common.functions.Partitioner;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 11:00
 * @description:
 */


public class MyPartitioner implements Partitioner<String> {
    @Override
    public int partition(String key, int numPartitions) {
        return Integer.parseInt(key) % numPartitions;
    }
}
