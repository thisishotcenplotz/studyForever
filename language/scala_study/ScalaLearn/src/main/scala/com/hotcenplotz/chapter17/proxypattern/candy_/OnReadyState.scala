package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:52 
 * @description:
 * */
class OnReadyState extends State {
    
    @transient private var candyMachine:CandyMachine = _
    
    def this(candyMachine: CandyMachine){
        this
        this.candyMachine = candyMachine
    }
    
    override def insertCoin(): Unit = {
        println("you have inserted a conte, next , please turn crank")
        this.candyMachine.setState(candyMachine)
    }
    
    override def returnCoin(): Unit = ???
    
    override def turnCrank(): Unit = ???
    
    override def printState(): Unit = println("OnReadyState")
    
    override def getStateName(): String = "***OnReadyState***"
    
    override def dispense(): Unit = ???
}
