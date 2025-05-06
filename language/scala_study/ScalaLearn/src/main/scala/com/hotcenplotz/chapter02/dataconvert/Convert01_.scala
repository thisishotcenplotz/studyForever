package com.hotcenplotz.chapter02.dataconvert

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 05:47 
 * @description:
 * 自动提升原则：表达式结果的类型自动提升为操作数中最大的类型
 */


object Convert01_ {
    def main(args: Array[String]): Unit = {
        val n1: Int = 10
        val n2: Float = 1.1f

        // 多类型运算时，低精度类型自动转换成高精度
        val n3: Float = n1 + n2

        // byte，short，和char之间不会自动转换类型
        val n4:Byte = 10
        val c1:Char = n4.toChar // byte 不会自动转成char，要手动

        // 强制类型转换
        val d: Double = 2.5
        val i: Int = d.toInt // 强制转换
    }
}
