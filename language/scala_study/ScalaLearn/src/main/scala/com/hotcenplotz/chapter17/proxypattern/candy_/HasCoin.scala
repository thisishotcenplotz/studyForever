package com.hotcenplotz.chapter17.proxypattern.candy_

import java.util.Random

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 07:22 
 * @description:
 * */
class HasCoin extends State {
    // @transient 注解将字段标记为瞬态的，即表示一个域不是该对象序列化的一部分。
    @transient private var candyMachine:CandyMachine = _
    
    // 观察candyMachine 的状态
    def this(candyMachine: CandyMachine){
        this
        this.candyMachine = candyMachine
    }
    
    override def insertCoin(): Unit = println("you can't insert another coin!")
    
    override def returnCoin(): Unit = {
        println("coin return")
        candyMachine.setState(candyMachine)
    }
    
    override def turnCrank(): Unit = {
        println("crank turn...!")
        val ranWinner: Random = new Random()
        val winner: Int = ranWinner.nextInt(10)
        
        if( winner == 0) candyMachine.setState(candyMachine)
        else candyMachine.setState(candyMachine)
    }
    
    override def printState(): Unit = println("***HasCoin***")
    
    override def getStateName(): String = "HasCoin State"
    
    override def dispense(): Unit = {}
}
