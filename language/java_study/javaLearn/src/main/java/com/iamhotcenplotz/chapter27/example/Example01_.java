package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 17:41
 * @description: 验证输入的是否全为汉字
 */


public class Example01_ {
    public static void main(String[] args) {
//        String content = "张三同学 Hello how are you 张三老师 find thank you 张三靓仔 and you i am find too";
        String content = "张三同学张三老师张三靓仔";
        String regStr = "^[\u0391-\uffe5]+$"; //汉字编码范围

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if(matcher.find()) {
            System.out.println("good");

        } else {
            System.out.println("bad");
        }
    }
}
