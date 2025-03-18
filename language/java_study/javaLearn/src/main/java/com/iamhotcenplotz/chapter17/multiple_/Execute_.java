package com.iamhotcenplotz.chapter17.multiple_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Execute_ {
    public static void main(String[] args) {
        Thread thread = new Thread(new SayHello());
        Thread thread1 = new Thread(new SayHi());

        thread.start();
        thread1.start();
    }
}
