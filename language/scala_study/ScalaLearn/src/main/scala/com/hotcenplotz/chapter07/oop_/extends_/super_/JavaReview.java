package com.hotcenplotz.chapter07.oop_.extends_.super_;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-12 05:49
 * @description:
 */


public class JavaReview {
    public static void main(String[] args) {
        B b = new B();

        B b2 = new B("zhang san");

    }
}


class A {
    public A() {
        System.out.println("A()");
    }

    public A(String name) {
        System.out.println("A(String name) " + name);
    }
}

class B extends A {
    public B() {
        System.out.println("B()");
    }
    public B(String name) {
        super(name);
        System.out.println("B(String name) " + name);
    }
}