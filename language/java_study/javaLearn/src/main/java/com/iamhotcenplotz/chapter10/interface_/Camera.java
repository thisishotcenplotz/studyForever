package com.iamhotcenplotz.chapter10.interface_;

public class Camera implements UsbInterface{
    @Override
    public void start() {
        System.out.println("Camera is running");
    }

    @Override
    public void stop() {
        System.out.println("Camera is stopped");
    }
}
