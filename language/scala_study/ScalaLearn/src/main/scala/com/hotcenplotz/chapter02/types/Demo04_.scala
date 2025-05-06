package com.hotcenplotz.chapter02.types

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-02 15:13 
 * @description:
 */


object Demo04_ {
    def main(args: Array[String]): Unit = {
        // 当输出一个char类型时，会输出该数字对应的字符(码值表 unicode)
        // unicode 码表是包含了ascii码表的
        var c: Char = 97
        println(c) // 会输出 a

        // 原因分析
        // (1) 当把一个计算的结果赋值给一个变量，则编译器会进行转换及判断（即会看返回+类型）
        // (2) 当把一个字面量赋值一个变量，则编译器会进行范围判断
//        var c2:Char = 'a' + 1 //会报错
//        val c3:Char = 87 + 1  //会报错
        var c4:Char = 98
//        var c5:Char = 99999  // 超过范围会报错


    }

}
