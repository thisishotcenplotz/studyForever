package com.iamhotcenplotz.chapter27.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 17:32
 * @description: 非捕获分组
 */


public class RegExp06 {
    public static void main(String[] args) {
        String content = "张三同学 Hello how are you 张三老师 find thank you 张三靓仔 and you i am find too";
        //String regStr = "张三同学|张三老师|张三靓仔"; // 演示给分组取名
        String regStr = "张三(?:老师|同学|靓仔)"; // 等价于上面的写法
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
