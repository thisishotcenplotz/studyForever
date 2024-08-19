package com.iamhotcenplotz.www.chapter05

import java.util.Scanner

object SwitchExample_ {
  def main(args: Array[String]): Unit = {
    var command: Char = 'a'

    command match {
      case 'a' => println("hello a")
      case 'b' => println("Hello b")
      case _ => println("Hello _")
    }


  }

  def exercise01(): Unit = {
    val scanner = new Scanner(System.in)

    val score = scanner.nextDouble()

    (score / 60).toInt match {
      case 0 => println("bad")
      case 1 => println("good")
      case _ => println("...")
    }
  }

}
