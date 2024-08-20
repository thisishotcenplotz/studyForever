package com.iamhotcenplotz.www.chapter05;

public class For01 {
    public static void example01() {
        int i = 0;
        for (; i < 10; ) {
            System.out.println(i);
            i++;
        }
    }

    public static void example02(){
        // 无限循环
        // 可以配合break使用
        for (;;){
            System.out.println("");
        }
    }
    public static void example03(){
        for (int i = 0, j = 0; i < 10000; i++,j+=2){
            System.out.println(i);
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello World");
        }

        example01();
    }
}
