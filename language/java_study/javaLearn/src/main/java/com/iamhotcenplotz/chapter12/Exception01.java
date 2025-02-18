package com.iamhotcenplotz.chapter12;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        try {
            int res = num1 / num2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("ok...keep going.");
        }

        System.out.println("...");
    }
}
