package com.iamhotcenplotz.chapter19.exercises_;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 使用BufferedReader 读取一个文件，为每行加上行号，然后打印
 */
public class Exercise02_ {
    public static void main(String[] args) throws IOException {
        String path = "./javaStudy.md";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(inputStreamReader);

        long cnt = 1;
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(cnt++ +" ---> "+line);
        }

        br.close();
    }
}
