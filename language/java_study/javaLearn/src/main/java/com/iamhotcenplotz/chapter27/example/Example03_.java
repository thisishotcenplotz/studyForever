package com.iamhotcenplotz.chapter27.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 17:58
 * @description: 验证url是否有效
 */


public class Example03_ {

    public static void main(String[] args) {
        String content = "https://www.bilibili.com/video/BV1JEL2zDEyL/?spm_id_from=333.1007.tianma.8-1-23.click&vd_source=be406716090579edb2c964c00ce554f4";
        String regStr = "^(htt(p|ps)://)(([\\w-])+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$"; // 等价于上面的写法
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }
}
