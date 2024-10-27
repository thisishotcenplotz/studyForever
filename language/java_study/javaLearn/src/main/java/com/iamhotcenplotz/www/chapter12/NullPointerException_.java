package com.iamhotcenplotz.www.chapter12;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class NullPointerException_ {
    public static void main(String[] args) {
        String name = null;

        try {
            System.out.println(name.length());
        } catch (Exception e) {
            throw new NullPointerException("it's null");
        }
    }
}
