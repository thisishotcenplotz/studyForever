package com.iamhotcenplotz.chapter19.standard_;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class InputAndOutput_ {
    public static void main(String[] args) {
        // 编译类型：InputStream
        // 运行类型：BufferedInputStream -> 字节流
        InputStream in = System.in;
        System.out.println(System.in.getClass());

        // 编译类型：PrintStream
        // 运行类型：PrintStream
        OutputStream out = System.out;
        System.out.println(System.out.getClass());
    }
}
