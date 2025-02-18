package com.iamhotcenplotz.chapter08.polymorphism_._dynamic;

public class A {
    public int i = 10;

    public int sum(){
        return this.getI() + 10;
    }

    public int sum1(){
        return this.i + 10;
    }

    public int getI(){
        return i;
    }
}
