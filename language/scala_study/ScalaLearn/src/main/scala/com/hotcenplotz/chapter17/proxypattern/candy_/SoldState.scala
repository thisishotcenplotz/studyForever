package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:52 
 * @description:
 * */
class SoldState extends State {
    @transient private var candyMachine:CandyMachine = _
    
    def this(candyMachine: CandyMachine){
        this
        this.candyMachine = candyMachine
    }
    
    override def insertCoin(): Unit = println("please wait! we are giving you a candy!")
    
    override def returnCoin(): Unit = ???
    
    override def turnCrank(): Unit = ???
    
    override def printState(): Unit = println("SoleState")
    
    override def getStateName(): String = "SoleState"
    
    override def dispense(): Unit = {}
}
