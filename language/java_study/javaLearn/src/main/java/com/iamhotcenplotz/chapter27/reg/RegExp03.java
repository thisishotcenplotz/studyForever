package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 14:45
 * @description: 演示限定符的使用
 */


public class RegExp03 {
    public static void main(String[] args) {
//        String content = "哼哼 哈哈 嘿嘿 吼吼 呵呵 哄哄 哐哐 叮叮 铛铛";
        String content = "1111111111";

        // String regStr = "a{3}"; //找3个a
        // String regStr = "1{4}"; //找4个1
        // String regStr = "(\\d){4}"; //找随意4位 的数字组合
        // String regStr = "a{3,4}"; // 找 aaa 或 aaaa, 默认贪婪匹配 也就是找多的优先
        // String regStr = "(\\p{InCJK_Unified_Ideographs})\\1"; // 匹配叠词
         String regStr = ""; //

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
