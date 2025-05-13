package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:28 
 * @description: */
class Exercise04BankAccount_(
    var balance: Double = 0
) {
    def deposit(amount:Double):Unit = {
        balance += amount
        println(s"存款成功！余额：$balance")
    }
    
    def withdraw(amount:Double):Unit = {
        if(amount <= balance){
            s"取款成功，账户余额：$balance"
        } else {
            println(s"账户余额不足，当前余额为: $balance")
        }
    }
}
