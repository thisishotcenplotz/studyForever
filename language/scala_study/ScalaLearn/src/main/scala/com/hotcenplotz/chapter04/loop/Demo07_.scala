package com.hotcenplotz.chapter04.loop

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 20:52 
 * @description: while loop
 *
 *               因为while中没有返回值，所以当要用该语句来计算并返回结果时，就不可避免的使用变量，
 *               而变量需要声明在while的外部，那么就等同于循环的内部对外部的变量造成了影响。
 *               ！！！所以，Scala不同建使用while，建议使用for
 */


object Demo07_ {
    def main(args: Array[String]): Unit = {

        var i: Int = 0
        while (i < 10) {
            i += 1
            println("Hello World")
        }

        var j: Int = 0
        do {
            println(j)
            j += 1
        } while (j < 10)

        (1 to 9).foreach{i =>
            val line: String = (1 to i).map{j => s"$i * $j = ${i*j}"}.mkString("\t")
            println(line)
        }
    }

    def exercise(): Unit = {
        for (i <- 1 to 9; j <- 1 to i) {
            print(s"$i * $j = ${i * j}\t")
            if (i == j) println()
        }
    }

}
