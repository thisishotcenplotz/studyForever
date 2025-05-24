package com.hotcenplotz.chapter14.whyrecursive

import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 10:32 
 * @description: Scala循环中不建议使用while 和 do...while，而是使用递归
 * */
object Demo01_whyRecursive {
    def main(args: Array[String]): Unit = {
        // 传统办法:
        val now: Date = new Date()
        val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val strNow: String = dateFormat.format(now)
        println(s"start time: $strNow")
        
        var res: BigInt = BigInt(0)
        var num: BigInt = BigInt(1)
        var maxVal = BigInt(100000000l)
        
        while (num <= maxVal) {
            res += num
            num += 1
        }
        val done: String = dateFormat.format(new Date())
        println(s"result: $res")
        println(s"completed at: $done")
        
        // 递归方式计算
        def mySum(num:BigInt,sum:BigInt):BigInt = {
            if(num <= 100000000l) mySum(num+1,sum + num)
            else sum
        }
        
        println(s"recursive start: ${dateFormat.format(new Date())}")
        mySum(BigInt(0),BigInt(1))
        println(s"recursive complete: ${dateFormat.format(new Date())}")
    }
    
}
