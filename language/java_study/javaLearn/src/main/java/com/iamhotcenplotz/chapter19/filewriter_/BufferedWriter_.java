package com.iamhotcenplotz.chapter19.filewriter_;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./test.txt"));

        bufferedWriter.write("Hello World, 你吃了么？");
        bufferedWriter.newLine();
        bufferedWriter.write("Hello World, 吃了点啥？");
        bufferedWriter.newLine();
        bufferedWriter.write("Hello World, 多吃点！");

        bufferedWriter.close();
    }
}
