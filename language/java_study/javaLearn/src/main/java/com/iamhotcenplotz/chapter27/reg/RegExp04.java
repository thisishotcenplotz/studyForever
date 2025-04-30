package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 15:10
 * @description: 演示定位符
 */


public class RegExp04 {
    public static void main(String[] args) {
        String content = "1123abcooo";

        // String regStr = "^\\d+\\w*";
        // String regStr = "^[0-9]+[a-z]*";
        //String regStr = "^[0-9]+[a-z]+$";
        String regStr = "ooo\\b"; // 匹配ooo结束的字符串中的ooo

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
