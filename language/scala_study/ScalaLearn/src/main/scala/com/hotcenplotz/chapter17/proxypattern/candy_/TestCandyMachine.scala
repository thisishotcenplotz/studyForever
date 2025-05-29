package com.hotcenplotz.chapter17.proxypattern.candy_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-30 05:53 
 * @description:
 * */
object TestCandyMachine {
    def main(args: Array[String]): Unit = {
        val monitor: Monitor = new Monitor()
        val machine1: CandyMachine = new CandyMachine("Location 1", 6)
        val machine2: CandyMachine = new CandyMachine("Location 2", 8)
        val machine3: CandyMachine = new CandyMachine("Location 3", 18)
        
        monitor.addMachine(machine1)
        monitor.addMachine(machine2)
        monitor.addMachine(machine3)
        
        monitor.report()
    }
}
