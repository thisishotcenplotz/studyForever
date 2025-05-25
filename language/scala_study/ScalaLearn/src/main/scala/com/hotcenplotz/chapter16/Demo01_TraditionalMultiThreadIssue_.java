package com.hotcenplotz.chapter16;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-25 08:41
 * @description: Why need Akka ?
 */


public class Demo01_TraditionalMultiThreadIssue_ {
    public static void main(String[] args) {

    }
}

// Multi-thread executed class
class Ticket {

    public void saleTicket(){

        // sale ticket logic code

        // sale it synchronized
        synchronized (this){
            // 互斥代码
            // which will affect the efficiency.
        }

        // code ...
    }
}