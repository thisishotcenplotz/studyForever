package com.iamhotcenplotz.chapter10.interface_;

public class Mysql implements Database{
    @Override
    public void connect() {
        System.out.println("mysql connected.");
    }

    @Override
    public void disconnect() {
        System.out.println("mysql disconnected.");
    }
}
