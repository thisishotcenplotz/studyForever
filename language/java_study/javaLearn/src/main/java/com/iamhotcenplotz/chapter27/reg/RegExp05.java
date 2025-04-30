package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 17:25
 * @description: 捕获分组
 */


public class RegExp05 {
    public static void main(String[] args) {
        String content = "1111 3333 5555 6666";
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d)(?<g3>\\d)"; // 演示给分组取名

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group("g1") + " " + matcher.group("g2") + " " + matcher.group("g3"));
        }
    }
}
