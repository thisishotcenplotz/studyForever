package com.iamhotcenplotz.chapter10.innerclass_;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        Outer10.Inner10.say();

        Outer10.Inner10.say();
    }
}

class Outer10 {
    private int n1 = 10;
    private static final String name = "zhang san";

    // 放在外部类的成员位置，并用static 使用
    // 只可以访问static 成员
    public static class Inner10 {
        public static void say(){
            System.out.println(Outer10.name);
        }
    }
}
