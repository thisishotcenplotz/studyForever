package com.iamhotcenplotz.chapter17.exercise_;

import com.iamhotcenplotz.chapter17.exercise_.tickets01_.TicketVendor;
import com.iamhotcenplotz.chapter17.exercise_.tickets02_.VendorMachine;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SaleTicket {
    public static void main(String[] args) {
        // one
//        TicketVendor ticketVendor = new TicketVendor();
//        TicketVendor ticketVendor1 = new TicketVendor();
//        TicketVendor ticketVendor2 = new TicketVendor();
//
//
//        ticketVendor.start();
//        ticketVendor1.start();
//        ticketVendor2.start();

        // two
        Thread thread = new Thread(new VendorMachine());
        Thread thread1 = new Thread(new VendorMachine());
        Thread thread2 = new Thread(new VendorMachine());

        thread.start();
        thread1.start();
        thread2.start();
    }
}
