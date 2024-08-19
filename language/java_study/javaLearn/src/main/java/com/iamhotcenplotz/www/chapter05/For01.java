package com.iamhotcenplotz.www.chapter05;

public class For01 {
    public static void example01() {
        int i = 0;
        for (; i < 10; ) {
            System.out.println(i);
            i++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello World");
        }

        example01();
    }
}
