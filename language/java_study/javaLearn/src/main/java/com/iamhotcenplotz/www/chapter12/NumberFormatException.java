package com.iamhotcenplotz.www.chapter12;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class NumberFormatException {
    public static void main(String[] args) {
        String name = "1234";

        int num = Integer.parseInt(name);

        try {
            int num2 = Integer.parseInt("abcd");
        } catch (java.lang.NumberFormatException e) {
            throw new java.lang.NumberFormatException("........");
        }
    }
}
