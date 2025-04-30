package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 18:57
 * @description: 结巴去重
 */


public class Example06_ {
    public static void main(String[] args) {
        String content = "我。。。。。我要。。。。。写写写写。。。。scala代码";
        String regStr = "。";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        String contentTwo = matcher.replaceAll("");

        // 去掉重复的字
        String regStrThree = "(.)\\1+";
        Pattern compileThree = Pattern.compile(regStrThree);
        Matcher matcherThree = compileThree.matcher(contentTwo);

        while (matcherThree.find()) {
            System.out.println(matcherThree.group(0));
        }
        String result = matcherThree.replaceAll("$1");
        System.out.println(result);

        System.out.println(Pattern.compile("(.)\\1+").matcher(contentTwo).replaceAll("$1"));

    }
}
