package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-29 07:19 
 * @description:
 * */
trait State extends Serializable{
    def insertCoin()
    def returnCoin()
    def turnCrank()
    def printState()
    def getStateName():String
    def dispense()
}
