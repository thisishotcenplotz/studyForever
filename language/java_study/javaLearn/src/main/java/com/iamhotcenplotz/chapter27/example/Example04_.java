package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 18:21
 * @description:
 */


public class Example04_ {
    public static void main(String[] args) {
        String content = "3.14 5.28 99.9 88.8 33";
        String regStr = "(\\d+\\.+\\d*)|(\\d+)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
