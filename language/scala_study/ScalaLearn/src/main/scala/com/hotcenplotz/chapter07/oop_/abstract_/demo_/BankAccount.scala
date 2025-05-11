package com.hotcenplotz.chapter07.oop_.abstract_.demo_

import scala.beans.BeanProperty

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-11 07:27 
 * @description: */
abstract class BankAccount(
    @BeanProperty accountNumber: String, @BeanProperty var balance: Double, @BeanProperty var password: String
) {
    
    def checkBalance(pwd: String): String = {
        if (pwd.equals(password)) s"Account Number: $accountNumber \n Balance: $balance" else "Wrong Password"
    }
    
    def deposit(amount: Double): Unit = {
        balance += amount
        println(s"Deposit of $amount Success.")
    }
    
    def withdraw(amount: Double): Unit = {
        if (balance >= amount) {
            balance -= amount
            println(s"Withdraw $amount Success")
        } else {
            println(s"Failed! The balance less than $amount")
        }
    }
}
