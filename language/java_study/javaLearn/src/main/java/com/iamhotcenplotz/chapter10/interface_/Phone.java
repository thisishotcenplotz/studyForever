package com.iamhotcenplotz.chapter10.interface_;

public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Phone is running");
    }

    @Override
    public void stop() {
        System.out.println("Phone is stopped");
    }
}
