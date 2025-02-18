package com.iamhotcenplotz.chapter04;

public class TernaryOperatorExercise {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        int left = (a > b ? a : b);
        int right = left > c ? left:c;
        System.out.println(right);
    }
}
