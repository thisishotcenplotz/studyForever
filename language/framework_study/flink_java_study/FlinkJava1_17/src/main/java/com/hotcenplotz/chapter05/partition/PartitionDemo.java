package com.hotcenplotz.chapter05.partition;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-06-08 09:32
 * @description: Partition Demo
 */


public class PartitionDemo {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment flink = StreamExecutionEnvironment.getExecutionEnvironment();
        flink.setParallelism(2);
        DataStreamSource<String> source = flink.socketTextStream("localhost", 10999);
        
        // TODO: Default
        // source.shuffle().print();
        
        // 默认分区策略 ->
        //    @Override
        //    public int selectChannel(SerializationDelegate<StreamRecord<T>> record) {
        //        return random.nextInt(numberOfChannels);
        //    }
        /* OUTPUT:
         * 1> 1
         * 2> 2
         * 2> 1
         * 2> 2
         * 1> 1
         * 1> 2
         * */
        
        
        // TODO: rebalance
        // source.rebalance().print();
        
        // source code
        //@Override
        //public int selectChannel(SerializationDelegate<StreamRecord<T>> record) {
        //    nextChannelToSendTo = (nextChannelToSendTo + 1) % numberOfChannels;
        //    return nextChannelToSendTo;
        //}
        
        // 如果数据源倾斜，调用rebalance 可以平衡下游任务不倾斜
        /**
         * 2> 1
         * 1> 2
         * 2> 3
         * 1> 4
         * 2> 5
         * 1> 6
         * */
        
        
        // TODO 3. rescale : 也是轮询，但是是局部组队
        // source.rescale().print();
        
        // TODO 4. broadcast : 发送给下游所有子任务, 即下游所有子任务雨露均沾~
        // source.broadcast().print();
        /**
         * 2> 1
         * 1> 1
         * 1> 2
         * 2> 2
         * 1> 3
         * 2> 3
         * 1> 4
         * 2> 4
         * */
        
        
        // TODO 5. global : 强制将数据都发送给下游的0号子任务
        source.global().print();
        
        /**
         * 1> 1
         * 1> 2
         * 1> 3
         * */
        
        // TODO 5. custom partitioner
        
        flink.execute();
        
        
    }
}
