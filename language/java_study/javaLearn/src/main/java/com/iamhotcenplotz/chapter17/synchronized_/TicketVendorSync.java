package com.iamhotcenplotz.chapter17.synchronized_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class TicketVendorSync extends Thread{

    private static int tickets = 100;

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

    @Override
    public synchronized void run() {
        sell();
    }
}
