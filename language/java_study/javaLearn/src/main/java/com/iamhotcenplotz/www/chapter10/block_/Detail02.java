package com.iamhotcenplotz.www.chapter10.block_;

public class Detail02 {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A {
    private int n2 = getN2();

    {
        System.out.println("A normal block...");
    }

    private static int n1 = getN1();

    static {
        System.out.println("A static block 01 ...");
    }

    public static int getN1() {
        System.out.println("getN1...");
        return 100;
    }

    public int getN2() {
        System.out.println("getN2...");
        return 200;
    }

    public A() {
        System.out.println("A constructor...");
    }
}
