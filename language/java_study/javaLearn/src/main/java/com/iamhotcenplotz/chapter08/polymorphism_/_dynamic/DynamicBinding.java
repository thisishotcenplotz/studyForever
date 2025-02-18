package com.iamhotcenplotz.chapter08.polymorphism_._dynamic;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.sum()); // -> 30
        System.out.println(a.sum1()); // -> 30
    }
}
