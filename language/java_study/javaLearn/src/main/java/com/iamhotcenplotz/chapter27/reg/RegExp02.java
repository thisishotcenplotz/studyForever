package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 13:37
 * @description: 演示字符匹配符
 */


public class RegExp02 {
    public static void main(String[] args) {
        String contest = "a11c8abcABCAbC";

        //String regStr = "[a-z]"; // 匹配任意一个小写字母
        //String regStr = "[A-Z]"; // 匹配任意一个大写字母
        //String regStr = "abc"; // 匹配abc区分大小写
        //String regStr = "(?i)abc"; // 匹配abc不区分大小写
        //String regStr = "a(?i)bc"; // bc 不区分大小写
        String regStr = "a((?i)b)c"; // b 不区分大小写


        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(contest);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
