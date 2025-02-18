package com.iamhotcenplotz.chapter08.super_;

public class B extends A {

    public B() {
        super();
    }

    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }

    public void ok() {
        super.test100();
        super.test200();
        super.test300();
        System.out.println("ok~ ");
    }
}
