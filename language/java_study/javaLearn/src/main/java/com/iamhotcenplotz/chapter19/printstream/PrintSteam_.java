package com.iamhotcenplotz.chapter19.printstream;

import java.io.PrintStream;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示PrintStream (字节打印流)
 */

public class PrintSteam_ {
    public static void main(String[] args) {
        PrintStream out = System.out;

        // 默认情况下，PrentStream 输出数据的位置是 标准输出，也就是显示器
        // 也就是说以后可以修改输出的位置..
        out.println("Hello World");

        out.close();
    }
}
