package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:51 
 * @description:
 * */
class CandyMachine(
    val location: String, var candyCount: Int
) {
    
    
    def setState(candyMachine: CandyMachine): Unit = {
        println(candyMachine.getLocation())
    }
    
    def getState(): Unit = {}
    
    def onReadyState(): Unit = {
        println("ready")
    }
    
    def winnerState(): Unit = {}
    
    def soldOutState(): Unit = {}
    
    def hasCoin(): Unit = {}
    
    def getLocation(): Unit = {}
    
    def getCount(): Unit = {}
}

