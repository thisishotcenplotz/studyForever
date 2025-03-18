package com.iamhotcenplotz.chapter17.exercise_;

import com.iamhotcenplotz.chapter17.exercise_.tickets01_.TicketVendor;
import com.iamhotcenplotz.chapter17.exercise_.tickets02_.VendorMachine;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SaleTicket {
    public static void main(String[] args) {
        TicketVendor ticketVendor = new TicketVendor();
        TicketVendor ticketVendor1 = new TicketVendor();
//        TicketVendor ticketVendor2 = new TicketVendor();
        ticketVendor.start();
        ticketVendor1.start();
//        ticketVendor2.start();
    }
}
