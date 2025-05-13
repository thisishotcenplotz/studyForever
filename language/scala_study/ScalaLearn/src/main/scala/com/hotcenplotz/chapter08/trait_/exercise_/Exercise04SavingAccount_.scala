package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:28 
 * @description: */
class Exercise04SavingAccount_(
    initialBalance: Double
) extends Exercise04BankAccount_(initialBalance) {
    private var freeTransactionCount: Int = _
    
    private def monthlyInterest(): Unit = {
        freeTransactionCount = 3
        super.deposit(1)
    }
    
    override def deposit(amount: Double): Unit = {
        freeTransactionCount -= 1
        
        if (freeTransactionCount <= 0) super.deposit(amount - 1) else super.deposit(amount)
    }
    
    override def withdraw(amount: Double): Unit = {
        freeTransactionCount -= 1
        
        if (freeTransactionCount <= 0) super.withdraw(amount + 1) else super.withdraw(amount)
    }
}
