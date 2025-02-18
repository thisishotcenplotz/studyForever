package com.iamhotcenplotz.chapter10.innerclass_;

public class InnerClass01 {
}

class Outer{
    private int n1 = 100;

    {
        System.out.println("this is outer..");
    }

    public void m1(){
        System.out.println("m1...");
    }

    public Outer(int n1) {
        this.n1 = n1;
    }

    class Inner{

    }
}
