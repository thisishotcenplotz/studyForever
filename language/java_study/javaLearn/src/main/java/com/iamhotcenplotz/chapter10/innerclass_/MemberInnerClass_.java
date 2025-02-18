package com.iamhotcenplotz.chapter10.innerclass_;

public class MemberInnerClass_ {
    public static void main(String[] args) {
        new Outer08().t1();
    }
}


class Outer08 {
    private int n1 = 10;
    public String name = "zhang san";

    // 成员内部类，定义在成员位置上

    class Inner08 {
        public void say(){
            System.out.println("inner...");
            System.out.println(n1 + " " + name);
            Outer08.this.say();
        }
    }

    public void t1() {
        new Inner08().say();
    }

    public void say(){
        System.out.println("outer ...");
    }
}