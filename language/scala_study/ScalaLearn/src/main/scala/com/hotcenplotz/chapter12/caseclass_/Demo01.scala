package com.hotcenplotz.chapter12.caseclass_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-21 07:01 
 * @description:
 * */
object Demo01 {
    def main(args: Array[String]): Unit = {
    }
}


abstract class Amount
case class Dollar(value:Double) extends Amount
case class Currency(value:Double,unit: String) extends Amount
case object NoAmount extends Amount