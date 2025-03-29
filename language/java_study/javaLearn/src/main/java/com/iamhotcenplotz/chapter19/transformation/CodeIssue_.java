package com.iamhotcenplotz.chapter19.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示中文乱码问题
 * 默认情况下，是按照UTF-8来读取文件的，如果不是UTF-8，如GBK-8，则会乱码
 * 所以，在读取的时候要指定编码方式
 */
public class CodeIssue_ {
    public static void main(String[] args) throws IOException {
        String filePath = "./javaStudy2.txt";
        BufferedReader bf = new BufferedReader(new FileReader(filePath));

        System.out.println(bf.readLine());

        bf.close();
    }
}
