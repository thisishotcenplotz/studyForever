package com.iamhotcenplotz.chapter12.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Throws01 {
    public static void main(String[] args) {
        new Throws01().f1();
    }

    public void f1() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./aaa.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void f2() throws FileNotFoundException,Exception {
        FileInputStream fileInputStream = new FileInputStream("./bbb.txt");
    }
}
