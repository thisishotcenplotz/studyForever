package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:49 
 * @description: */
object Test {
    def main(args: Array[String]): Unit = {
        //val account = new Exercise04CheckingAccount_(100)
        
        //account.withdraw(10)
        //account.deposit(20)
        
        val labeled: Exercise05PointLabeled_ = Exercise05PointLabeled_("test", 1, 2)
        println(labeled)
    }
    
}
