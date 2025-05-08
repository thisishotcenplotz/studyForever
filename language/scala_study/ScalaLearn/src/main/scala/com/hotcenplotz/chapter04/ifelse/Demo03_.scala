package com.hotcenplotz.chapter04.ifelse

import scala.io.StdIn

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-08 06:34 
 * @description: 多分支
 */


object Demo03_ {
    def main(args: Array[String]): Unit = {
        print("请输入成绩:")
        val score: Int = StdIn.readInt()

        if ( score == 100) {
            println("100")
        } else if (score > 80 && score <= 99){
            println("80")
        } else if (score > 60 && score <= 80){
            println("60")
        } else {
            println("......")
        }

    }
}
