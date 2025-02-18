package com.iamhotcenplotz.chapter10.interface_;

public class Oracle implements Database{
    @Override
    public void connect() {
        System.out.println("Connected to Oracle");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from Oracle");
    }
}
