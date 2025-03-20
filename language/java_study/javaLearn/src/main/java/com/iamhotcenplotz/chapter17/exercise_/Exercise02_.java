package com.iamhotcenplotz.chapter17.exercise_;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * @author Der Hotcenplotz
 * @version 1.0
 * Exercise 02: 用户取钱
 *
 * 1. 有2个用户分别从同一个卡上取钱（总金额10000）
 * 2. 每次都取1000，当余额不足时就不能取款了
 * 3. 不能出现超额取钱现象。 => synchronized
 */
public class Exercise02_ {
    public static void main(String[] args) {
        Thread thread = new Thread(new BankAccount("zhang san"));
        Thread thread1 = new Thread(new BankAccount("li si"));
        Thread thread2 = new Thread(new BankAccount("wang wu"));

        thread.start();
        thread1.start();
        thread2.start();
    }
}


class BankAccount implements Runnable {
    private static int balance = 10000;
    private String userName;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public BankAccount(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String now() {
        return LocalDateTime.now().format(formatter);
    }

    public synchronized void withdraw() {
        if (balance >= 1000) {
            balance -= 1000;
            System.out.println("["+this.now()+ "] - " + this.userName + " - withdraw $1000 from account. The account balance is: " + this.balance);
        } else {
            System.out.println("The account balance is less than $1000. Withdraw failed.");
        }
    }

    @Override
    public void run() {
        while (balance > 0) {

            withdraw();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}