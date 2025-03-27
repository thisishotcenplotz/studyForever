package com.iamhotcenplotz.chapter19.filereader_;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * BufferedReader 最好读文本文件，如果读二进制文件可能有缺失
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception{
        String filePath = "./pom.xml";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        // 按行读取，当返回空时，读取完毕
        bufferedReader.lines().forEach(System.out::println);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
