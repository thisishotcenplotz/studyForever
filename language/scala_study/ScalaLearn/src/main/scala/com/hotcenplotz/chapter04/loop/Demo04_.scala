package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 08:17 
 * @description: loop with return
 *               在循环中使用yield关键字，返回一个Vector集合
 */


object Demo04_ {
    def main(args: Array[String]): Unit = {
        // 1. 对 1 到 10 进行遍历
        // 2. 循环中每次的i放入一个Vector，并将结果返回给rows
        // 3. yield 后 可跟一个代码块，所以可以加入复杂处理
        // 4. 这种写法体现出了Scala的一个重要语法特点
        //    即：特别擅长将一个集合中所有数据分别处理并返回一个新的集合
        val rows: IndexedSeq[Int] = for (i <- 1 to 100) yield i * 2
        rows.foreach(println)

        // 示例2
        val result: IndexedSeq[Any] = for (i <- 1 to 100; j <- 1 to 100) yield {
            if ((i * j) % 5 == 0) s"i:$i -> j:$j" else ""
        }
        result.filter(i => i != "").foreach(println)

    }
}
