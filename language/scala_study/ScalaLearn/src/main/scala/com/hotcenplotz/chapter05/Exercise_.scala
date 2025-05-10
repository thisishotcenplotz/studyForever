package com.hotcenplotz.chapter05

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 10:10 
 * @description:
 */


object Exercise_ {

    def main(args: Array[String]): Unit = {
        printTriangle(10)

        printInvertedTriangle(10)

        printHollowTriangle(10)

    }


    def printTriangle(n: Int): Unit = {
        (1 to n).foreach { i =>
            println((" " * (n - i)) + ("*" * (2 * i - 1)))
        }
    }

    def printInvertedTriangle(n: Int): Unit = {
        (1 to n).reverse.foreach { i =>
            println((" " * (n - i)) + ("*" * (2 * i - 1)))
        }
    }

    def printHollowTriangle(n: Int): Unit = {
        (1 to n).foreach {
            rowNum: Int =>
                rowNum match {
                    case 1 => println((" " * (n - rowNum)) + "*")
                    case `n` => println(("*" * (2 * rowNum - 1)))
                    case _ => {
                        val begin: String = " "*(n-rowNum)
                        val middle: String = " "*(2*(rowNum-1) - 1)
                        println(begin + "*" + middle + "*")
                    }
                }
        }
    }
}
