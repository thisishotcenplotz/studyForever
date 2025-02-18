package com.iamhotcenplotz.chapter04;

public class LogicOperator01 {
    public static void main(String[] args) {
        // &&  and &
        int age = 50;
        if (age > 20 && age < 90) {
            System.out.println("ok100");
        }
        //  &
        if (age > 30 & age < 50) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // difference

        int a = 4;
        int b = 9;
        if (a < 1 && ++b < 50) {
            System.out.println("ok300");
        }
        System.out.println("a = " + a + " b = " + b);

        if (a < 1 & ++b < 50) {
            System.out.println("ok400");
        }
        System.out.println("a = " + a + " b = " + b);

    }
}
