package com.iamhotcenplotz.chapter12;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};

        try {
            System.out.println(chars[3]);
        } catch (Exception e) {
            throw new java.lang.ArrayIndexOutOfBoundsException("....");
        }
    }
}
