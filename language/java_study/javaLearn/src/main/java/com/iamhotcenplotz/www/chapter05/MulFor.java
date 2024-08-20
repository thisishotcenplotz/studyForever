package com.iamhotcenplotz.www.chapter05;

public class MulFor {
    public static void exercise01() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static void exercise02() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    public static void exercise03() {
        // 空心三角形？

        int size = 15;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size / 2; j++) {
                System.out.print("*");
            }
            for (int k = size / 2 + 1; k < size; k++) {

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
    }
}
