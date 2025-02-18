package com.iamhotcenplotz.chapter07;

public class Recursive {
    public static void test01(int n) {
        if (n > 1) {
            test01(n - 1);
        }
        System.out.println("n = " + n);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int monkey(int n) {
        if (n >= 2) {
            return (monkey(n - 1) + 1) * 2;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {
//        test01(10);
//        System.out.println(factorial(10));
//        System.out.println(fibonacci(20));
        System.out.println(monkey(10));
    }
}


