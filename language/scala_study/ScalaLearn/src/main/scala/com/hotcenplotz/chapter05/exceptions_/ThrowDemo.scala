package com.hotcenplotz.chapter05.exceptions_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-10 09:49 
 * @description:
 */


object ThrowDemo {

    def main(args: Array[String]): Unit = {
        try{
            test()
        } catch {
            case e:Exception => println(e.getMessage)
        } finally {
            println("ok~")
        }
    }

    def test():Nothing = {
        throw new Exception("Oops... Something wrong...")
    }

    @throws(classOf[NumberFormatException]) // 等同于 NumberFormatException.class
    def test2(): Unit = {
        println("提示可能抛出NumberFormatException异常")
    }

}
