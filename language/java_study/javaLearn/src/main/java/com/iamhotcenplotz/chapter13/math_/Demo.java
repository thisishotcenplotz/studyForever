package com.iamhotcenplotz.chapter13.math_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-9));

        System.out.println(Math.pow(2, 2));

        System.out.println(Math.ceil(0.01));
        System.out.println(Math.floor(1.01));

        System.out.println(Math.round(1.11));

        System.out.println(Math.sqrt(4.00));

        for (int i = 0; i < 100; i++) {
            System.out.println(Math.random() * 100);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println(Math.random() * 1000);
        }
    }
}
