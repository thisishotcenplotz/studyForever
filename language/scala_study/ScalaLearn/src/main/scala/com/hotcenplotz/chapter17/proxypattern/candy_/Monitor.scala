package com.hotcenplotz.chapter17.proxypattern.candy_

import scala.collection.mutable.ListBuffer

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:51 
 * @description:
 * */
class Monitor {
    private val candyMachineList: ListBuffer[CandyMachine] = ListBuffer()
    
    def addMachine(candyMachine: CandyMachine) = candyMachineList.addOne(candyMachine)
    
    def report(): Unit = {
        for (machine <- candyMachineList) {
            println(
                s"""
                   |+++++++++++++++++++++++
                   |+ Machine Location    : ${machine.getLocation()}
                   |+ Machine Candy Count : ${machine.getCount()}
                   |+ Machine State       : ${machine.getState()}
                   |+++++++++++++++++++++++
                   |""".stripMargin
            )
        }
    }
    
}
