package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 20:38 
 * @description: for 循环控制步长
 */


object Demo06_ {
    def main(args: Array[String]): Unit = {

        // Method 1
        // def apply(start: Int, end: Int, step: Int): Range.Exclusive =
        //      new Range.Exclusive(start, end, step)
        for (i <- Range(1, 10, 2)) {
            println(s"step: $i")
        }

        // Method 2
        for (i <- 1 to 10 if i % 2 == 1) {
            println(s"method 2 step: $i")
        }
    }

    def exercise01(): Unit = {
        val start: Int = 1
        val end: Int = 100
        var count: Int = 0
        var sum: Int = 0

        for (i <- start to end if i % 9 == 0) {
            count += 1
            sum += i
        }

        println(s"sum:$sum --> count:$count")
    }

    def exercise02():Unit = {
        for( i<- 0 to 6){
            println(s"$i + ${6 - i} = 6")
        }
    }
}
