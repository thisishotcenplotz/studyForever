package com.iamhotcenplotz.chapter17.exercise_.tickets02_;

import com.iamhotcenplotz.chapter14.map_.TreeMap_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class VendorMachine implements Runnable{
    private static int tickets = 100;

    @Override
    public void run() {
        while (tickets >= 0){
            System.out.println("Vendor " +Thread.currentThread().getName()+" sold a ticket, " + (--tickets) + " left...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
