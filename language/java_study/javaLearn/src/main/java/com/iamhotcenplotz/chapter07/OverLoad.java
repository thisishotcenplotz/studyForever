package com.iamhotcenplotz.chapter07;

public class OverLoad {
    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        System.out.println(myCalculator.calculate(1, 2));
    }
}

class MyCalculator {

    public int calculate(int a, int b) {
        return a + b;
    }

    public double calculate(int a, double b) {
        return (double) a + b;
    }

    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}
