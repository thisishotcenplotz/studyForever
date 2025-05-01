package com.hotcenplotz

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-01 08:20 
 * @description: Revisiting Scala For the Second Time.
 */


object Main {
  def main(args: Array[String]): Unit = {
    hello()
  }

  def hello():Unit = {
    (1 to 100).foreach(_ => println("Hello Scala again!"))
  }
}
