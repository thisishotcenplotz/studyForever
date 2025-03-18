package com.iamhotcenplotz.chapter17.exercise_.tickets02_;

import com.iamhotcenplotz.chapter14.map_.TreeMap_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class VendorMachine implements Runnable{
    private String vendorName;

    private int tickets;

    public VendorMachine(String vendorName, int tickets) {
        this.vendorName = vendorName;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println(this.vendorName + " sold a ticket, " + tickets-- + " tickets left");
        }

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
