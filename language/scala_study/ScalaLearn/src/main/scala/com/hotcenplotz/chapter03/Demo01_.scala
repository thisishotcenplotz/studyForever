package com.hotcenplotz.chapter03

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 07:13 
 * @description:
 */


object Demo01_ {
    def main(args: Array[String]): Unit = {
        val d: Double = 10.0 / 3
        println(d.formatted("%.2f"))

        println(getRestDays(97))
    }

    def getRestDays(days: Int): String = {
        lazy val resDays: Int = days % 7
        val weeks: Int = days / 7

        s"Rest $weeks weeks and $resDays days"
    }
}
