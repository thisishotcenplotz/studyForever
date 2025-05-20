package com.hotcenplotz.chapter12

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-20 07:34 
 * @description: 匹配数组
 * */
object Demo05_ {
    def main(args: Array[String]): Unit = {
        val arr: Array[Array[Int]] = Array(Array(0), Array(1, 0), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))
    
        for(arr <- arr){
            arr match {
                case Array(0) => println("0")
                case Array(x,y) => println(s"($x,$y)")
                case Array(0,_*) => println("0 开头")
                case _ => println("啥也不是")
            }
        }
        
        for(arr <- arr){
            arr match {
                case Array(x,y) => println(s"($y,$x)")
                case _ => println("啥也不是")
            }
        }
        
        //匹配列表
        val list: List[List[Int]] = List(List(1, 0), List(0, 0, 0), List(1, 0, 0))
        
        for(l <- list){
            val rst: String = l match { // 0 开头
                case 0 :: Nil => "0"
                
                // 最少2个数
                case x :: y :: Nil => x + " " + y
                case 0 :: tail => "0..."
                case _ => "Oops..."
            }
            println(rst)
        }
    }
}
