package com.iamhotcenplotz.chapter17.synchronized_;

import com.iamhotcenplotz.chapter17.exercise_.tickets01_.TicketVendor;
import com.iamhotcenplotz.chapter17.exercise_.tickets02_.VendorMachine;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SaleTicketSync {
    public static void main(String[] args) {
        // one
        TicketVendorSync ticketVendorSync = new TicketVendorSync();
        TicketVendorSync ticketVendorSync1 = new TicketVendorSync();
        TicketVendorSync ticketVendorSync2 = new TicketVendorSync();

        ticketVendorSync.start();
        ticketVendorSync1.start();
        ticketVendorSync2.start();


        // two
//        VendorMachineSync vendorMachineSync = new VendorMachineSync();
//        new Thread(vendorMachineSync).start();
//        new Thread(vendorMachineSync).start();
//        new Thread(vendorMachineSync).start();

    }
}
