package com.iamhotcenplotz.chapter13.wrapper_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class WrapperVsString {
    public static void main(String[] args) {
        // Integer -> String
        Integer i = 100;

        // method 1
        String str1 = i + "";

        // method 2
        String str2 = i.toString();

        // method 3
        String str3 = String.valueOf(i);

        // String -> Integer

        String str = "12345";

        // method 1
        Integer int1 = Integer.parseInt(str);




    }
}
