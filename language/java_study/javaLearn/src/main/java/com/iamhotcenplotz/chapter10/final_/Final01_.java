package com.iamhotcenplotz.chapter10.final_;

public class Final01_ {
    public static void main(String[] args) {

    }
}

final class A {

}

class B {
    public final void hi(){
        System.out.println("Hi...");
    }
}

class C {
    public final double RATE = 0.08;
}

// final 和 static 往往搭配使用效率更高；因为不会导致类加载

class D {
    public static final int NUM = 100;

    // 如果只调 D.NUM ，则下面static{} 不会执行。
    static {
        System.out.println("D static block...");
    }
}