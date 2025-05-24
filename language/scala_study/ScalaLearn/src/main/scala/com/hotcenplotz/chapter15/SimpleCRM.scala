package com.hotcenplotz.chapter15

import com.hotcenplotz.chapter15.view.CustomerPageView

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-24 14:23 
 * @description: Simple CRM Project
 * */
object SimpleCRM {
    def main(args: Array[String]): Unit = {
        val view = new CustomerPageView
        
        view.mainMenu()
    }
}
