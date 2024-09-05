package com.iamhotcenplotz.www.chapter08.extend_;

import java.util.Scanner;

public class Detail {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.sayOk();
    }
}

// 子类继承了所有的属性和方法，非私有的属性和方法可以在子类中直接访问，但非私有的属性和方法
// 不能在子类直接访问，要通过公共的方法去访问
class Base {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Base() {
        System.out.println("base()...");
    }

    public int getN4() {
        return n4;
    }

    public void test100() {
        System.out.println("test100()...");
    }

    protected void test200() {
        System.out.println("test200()...");
    }

    void test300() {
        System.out.println("test300()...");
    }

    private void test400() {
        System.out.println("test400()...");
    }

    public void callTest400(){
        this.test400();
    }
}

class Sub extends Base {
    public Sub() {
        System.out.println("sub()...");
    }
    public void sayOk(){
        System.out.println(this.n1);
        System.out.println(this.n2);
        System.out.println(this.n3);
        System.out.println(this.getN4());

        this.test100();
        this.test200();
        this.test300();
        this.callTest400();

    }
}