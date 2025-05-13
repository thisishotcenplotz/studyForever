package com.hotcenplotz.chapter08.trait_.exercise_

/**
 * @author: Der Hotcenplotz
 * @version： 1.0 
 * @date: 2025-05-13 07:28 
 * @description: */
class Exercise04CheckingAccount_(
    initialBalance: Double
) extends Exercise04BankAccount_(initialBalance) {
    
    override def deposit(amount: Double): Unit = {
        balance += amount
        balance -= 1
        println(s"此次存款手续费为1元")
        println(s"存款成功，当前余额:$balance")
    }
    
    override def withdraw(amount: Double): Unit = {
        val fee: Double = 1.0
        
        if (amount > balance) {
            println(s"余额不足，当前余额为：$balance")
            return
        }
        
        // 计算实际需要扣除的总额（本金+手续费）
        val totalDeduction: Double = amount + fee
        
        // 情况1: 余额足够支付本金+手续费
        if (totalDeduction <= balance) {
            balance -= totalDeduction
            println(s"取款成功！手续费$fee 元，当前余额为：$balance")
            return
        }
        
        // 情况2: 本金足够支付手续费（从本金中扣除）
        if (amount >= fee) {
            balance -= amount
            val actualWithdrawal = amount - fee
            println(s"可取金额为：$actualWithdrawal（已扣除手续费$fee 元）")
            println(s"当前余额为：$balance")
        } else { // 情况3: 本金不足以支付手续费
            println(s"错误：取款金额需至少覆盖手续费$fee 元")
        }
        
    }
}
