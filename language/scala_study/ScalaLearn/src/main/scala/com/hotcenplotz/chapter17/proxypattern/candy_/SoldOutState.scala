package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:52 
 * @description:
 * */
class SoldOutState extends State {
    
    @transient private var candyMachine:CandyMachine = _
    
    def this(candyMachine: CandyMachine) {
        this
        this.candyMachine = candyMachine
    }
    
    override def insertCoin(): Unit = println("you can't insert coin, the machine sold out")
    
    override def returnCoin(): Unit = ???
    
    override def turnCrank(): Unit = ???
    
    override def printState(): Unit = println("***SoldOutState***")
    
    override def getStateName(): String = "SoldOutState"
    
    override def dispense(): Unit = ???
}
