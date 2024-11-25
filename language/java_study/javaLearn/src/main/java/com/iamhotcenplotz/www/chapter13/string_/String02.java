package com.iamhotcenplotz.www.chapter13.string_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class String02 {
    public static void main(String[] args) {
        // method 1
        String str1 = "Hello World";

        // method 2
        String str2 = new String("Hello World");

        // 返回池的地址中的东西
        System.out.println(str1.intern());
    }
}
