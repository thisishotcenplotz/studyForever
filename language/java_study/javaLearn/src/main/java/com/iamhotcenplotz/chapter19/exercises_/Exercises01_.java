package com.iamhotcenplotz.chapter19.exercises_;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercises01_ {
    public static void main(String[] args) throws IOException {
        String directory = "temp";

        // 1. 判断 是否有xxx文件夹，如果没有则创建
        File file = new File(directory);

        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("ok~");
            } else {
                System.out.println("bad~");
            }
        } else {
            System.out.println(directory + " exists");
        }

        // 2. 在xxx文件夹下创建hello.txt
        String fileName = directory + "/hello.txt";
        File helloFile = new File(fileName);
        if (!helloFile.exists()) {
            if(helloFile.createNewFile()){
                System.out.println("ok~");
            } else {
                System.out.println("bad~");
            }
        } else {
            System.out.println(fileName + " already exists");
        }
        // 3. 如果hello.txt 已经存在就不重复创建了
        // 4. 随便写点什么到hello.txt
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        fileWriter.write("Hello World");
        fileWriter.close();

    }
}
