package com.iamhotcenplotz.www.chapter10.block_;

public class Detail03 {

    public static void main(String[] args) {
        new BBB();
    }

}

class AAA {
    {
        System.out.println("AAA block ...");
    }
    public AAA() {
        System.out.println("AAA() constructor...");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB block...");
    }

    public BBB() {
        // 1. super()
        // 2. 普通代码块
        System.out.println("BBB() constructor...");
    }
}
