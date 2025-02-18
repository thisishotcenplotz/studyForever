package com.iamhotcenplotz.chapter08.object_;

public class Equals01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;

        System.out.println(a == b);
        System.out.println(a.equals(b));

        String str = "hello";
        String number = "123";
        str.equals(number);
    }

}

class A{}