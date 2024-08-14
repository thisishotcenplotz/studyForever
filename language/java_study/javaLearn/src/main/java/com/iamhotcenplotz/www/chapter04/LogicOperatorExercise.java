package com.iamhotcenplotz.www.chapter04;

public class LogicOperatorExercise {
    public static void exercise01() {
        int x = 5;
        int y = 5;
        if (x++ == 6 & ++y == 6) {
            x = 11;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println("~~~~~~~~~~~~~~~~~~");

    }

    public static void exercise02() {
        int x = 5;
        int y = 5;
        if (x++ == 5 | ++y == 5) {
            x = 11;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println("~~~~~~~~~~~~~~~~~~");
    }

    public static void exercise03() {
        int x = 5;
        int y = 5;
        if (x++ == 6 | ++y == 6) {
            x = 11;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println("~~~~~~~~~~~~~~~~~~");
    }

    public static void exercise04() {
        int x = 5;
        int y = 5;
        if (x++ == 5 || ++y == 5) {
            x = 11;
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println("~~~~~~~~~~~~~~~~~~");
    }

    public static void exercise05() {
        boolean x = true;
        boolean y = false;
        short z = 46;
        if ((z++ == 46) && (y == true)) z++;
        if ((x == false) || (z++ == 46)) z++;
        System.out.println(z);
        System.out.println("~~~~~~~~~~~~~~~~~");

    }

    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();
        exercise05();


    }
}
