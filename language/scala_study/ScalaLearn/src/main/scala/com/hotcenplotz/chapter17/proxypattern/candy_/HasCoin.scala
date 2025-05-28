package com.hotcenplotz.chapter17.proxypattern.candy_

import java.util.Random

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 07:22 
 * @description:
 * */
class HasCoin extends State {
    
    
    override def insertCoin(): Unit = println("you can't insert another coin!")
    
    override def returnCoin(): Unit = {
        println("coin return")
    }
    
    override def turnCrank(): Unit = {
        println("crank turn...!")
        val ranWinner: Random = new Random()
        val winner: Int = ranWinner.nextInt(10)
        
        if( winner == 0) ...
        else ...
    }
    
    override def printState(): Unit = "***HasCoin***"
    
    override def getStateName(): String = "HasCoin State"
    
    override def dispense(): Unit = ???
}
