package com.iamhotcenplotz.chapter17.synchronized_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class TicketVendorSync extends Thread{

    private static int tickets = 100;

    // 同步方法，此时锁在this对象。
    public synchronized void sell() {
        while (tickets >= 0){
            System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (tickets--) + " left...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 也可以在代码块上写synchronized，这样就是一个同步代码块；互斥锁还是在this对象。
    public void sellTwo(){
        synchronized (this){
            while (tickets >= 0){
                System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (tickets--) + " left...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public synchronized void run() {
        sellTwo();
    }
}
