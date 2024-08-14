package com.iamhotcenplotz.www.chapter04;

public class TernaryOperator {
    public static void main(String[] args) {
        int a = 10;
        int b = 99;
        int rst = a > b ? a++:b--;
        System.out.println(rst);
        System.out.println(b);
    }
}
