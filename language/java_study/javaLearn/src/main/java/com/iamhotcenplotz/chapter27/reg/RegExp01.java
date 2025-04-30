package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 13:14
 * @description: 演示转义字符的使用
 */


public class RegExp01 {
    public static void main(String[] args) {
        String contest = "abc$(a.bc(123(";

        String regStr = "\\."; // 如果要匹配 . 的话要加转义符
//        String regStr = "."; // . 默认匹配所有字符

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(contest);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
