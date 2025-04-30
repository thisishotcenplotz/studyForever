package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 17:47
 * @description: 邮政编码
 */


public class Example02_ {

    public static void main(String[] args) {
        String content = "518000";
        String regStr = "^[1-9]\\d{5}$"; // 等价于上面的写法
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        if(matcher.find()) {
            System.out.println("good");

        } else {
            System.out.println("bad");
        }
    }
}
