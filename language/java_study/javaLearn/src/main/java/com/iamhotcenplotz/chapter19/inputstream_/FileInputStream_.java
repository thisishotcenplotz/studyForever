package com.iamhotcenplotz.chapter19.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 *
 * 字节输入流（文件 -> 程序）
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 单个字节读取，效率比较低
     * -> 使用read(byte[] b) 读取
     * */
    @Test
    public void readFile01() {
        int readData = 0;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("./hello.txt");

            // 如果返回-1 则表示文件读完了
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)(readData));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 使用read(byte[] b) 读取，提高效率
     * */
    @Test
    public void readFile02() {
        FileInputStream fileInputStream = null;

        // 一次读取8个字节
        byte[] buffer = new byte[8];
        int readLength = 0;

        try {
            fileInputStream = new FileInputStream("./hello.txt");

            // 如果返回-1 则表示文件读完了
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                System.out.print(new String(buffer,0, readLength));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
