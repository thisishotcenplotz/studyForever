package com.hotcenplotz.chapter10.map_

import scala.collection.mutable

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-18 09:05 
 * @description: Scala Map 示例代码
 * */
object Demo01_ {
    def main(args: Array[String]): Unit = {
        // 1. 默认时immutable map
        // 2. k-v 类型如果不写泛型可以随便写
        // 3. 在底层使用的是Tuple2
        // 4. 遍历顺序与赋值顺序一致。
        // 5. immutable.Map 不允许修改值
        val map: Map[String, Int] = Map[String, Int]("No1" -> 100, "No2" -> 200)
        
        // 构建可变Map
        // mutable.Map 可以修改值
        val map2: mutable.Map[String, Int] = mutable.Map("Spark" -> 1, "Flink" -> 2, "Kafka" -> 3)
        map2.addOne(("Delta Lake",4))
        
        for((k,v) <- map2) println((k,v))
        
        println(map2.contains("Delta Lake")) // if ket set contains k
        println(map2.getOrElse("Delta Lake", 666)) // if key exist then return else default
        map2.remove("Flink")
        map2.foreach( t => println((t._1, t._2)))
    }
}
