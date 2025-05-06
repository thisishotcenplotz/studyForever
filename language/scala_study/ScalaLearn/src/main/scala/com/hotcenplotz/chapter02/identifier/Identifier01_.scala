package com.hotcenplotz.chapter02.identifier

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-07 06:59 
 * @description:
 */


object Identifier01_ {
    def main(args: Array[String]): Unit = {
        // 首字符为操作符(+-*/), 后续必须跟一个操作符，至少一个
        val ++ = "hello world"

        // 关键字也可以做标识符，但是要加反引号
        val `true`: String = "Hello true"
    }

}
