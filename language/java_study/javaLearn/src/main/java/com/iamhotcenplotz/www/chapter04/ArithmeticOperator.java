package com.iamhotcenplotz.www.chapter04;

public class ArithmeticOperator {
    public static void main(String[] args) {
        // divide
        System.out.println(10 / 4); // 2
        double d = 10.0 / 4;
        System.out.println(d); // 2.5

        // mod
        // 在 Java 中 mod = a % b = a - a / b * b
        System.out.println(10 % 3);
        System.out.println(-10 % 3);
        System.out.println(10 % -3); // 10 - (-10) / 3 * 3 = 1
        System.out.println(-10 % -3);

        // ++
        int i = 10;
        i++;
        ++i;
        System.out.println("i = " + i);

        int j = 8;
//        int k = ++j;
        int k = j++;
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }
}
