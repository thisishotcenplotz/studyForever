package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 18:50
 * @description: 反向引用，匹配连续相同的字符
 */


public class Example05_ {
    public static void main(String[] args) {
        String content = "11.22 33.44 55.66 77.88 111999 33333 6996";
//        String regStr = "(\\d)\\1{4}";
        String regStr = "(\\d)(\\d)\\2\\1";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
