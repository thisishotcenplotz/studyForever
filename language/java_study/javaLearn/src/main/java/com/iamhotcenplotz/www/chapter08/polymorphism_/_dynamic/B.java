package com.iamhotcenplotz.www.chapter08.polymorphism_._dynamic;

public class B extends A{
    public int i = 20;

//    public int sum() {
//        return this.i + 20;
//    }

    public int getI(){
        return this.i;
    }

    public int sum1(){
        return i + 10;
    }
}
