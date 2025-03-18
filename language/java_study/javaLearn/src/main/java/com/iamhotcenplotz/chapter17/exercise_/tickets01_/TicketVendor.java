package com.iamhotcenplotz.chapter17.exercise_.tickets01_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class TicketVendor extends Thread{

    private static int tickets = 100;

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println("Vendor 01 sold a ticket, " + (tickets--) + " left...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
