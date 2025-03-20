package com.iamhotcenplotz.chapter17.synchronized_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class VendorMachineSync implements Runnable{
    private static int tickets = 100;

    Object obj = new Object();

    // method one:
    public synchronized void sell(){
        while (tickets > 0){
            System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (--tickets) + " left...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // method two
    // add synchronized to obj
    public void sellTwo(){
        synchronized (obj){
            while (tickets > 0){
                System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (--tickets) + " left...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // 当同步方法（静态的）的锁为当前类本身
    // 即：VendorMachineSync.class
    public synchronized static void sellThree(){
        while (tickets > 0){
            System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (--tickets) + " left...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 静态方法实现同步代码块
    public static void someMethod() {
        synchronized (VendorMachineSync.class) {
            System.out.println("someMethod");
        }
    }


    @Override
    public void run() {
        sell();
    }
}
