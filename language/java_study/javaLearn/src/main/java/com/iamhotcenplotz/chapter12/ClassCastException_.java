package com.iamhotcenplotz.chapter12;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B();
        B b2 = (B)b;
        try {
            C c = (C)b;
        } catch (Exception e) {
            throw new ClassCastException("...");
        }
    }
}

class A{}
class B extends A{}
class C extends A{}