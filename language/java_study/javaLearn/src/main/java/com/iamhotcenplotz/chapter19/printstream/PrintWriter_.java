package com.iamhotcenplotz.chapter19.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * PrintWriter Demo
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Hello World");
        printWriter.close();

        PrintWriter printWriter1 = new PrintWriter(new FileWriter("./test.txt"));
        printWriter1.println("Hello World ~~~");
        printWriter1.close();
    }
}
