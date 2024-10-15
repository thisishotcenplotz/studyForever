package com.iamhotcenplotz.www.chapter10.static_;

public class VisitStatic {
    public static void main(String[] args) {
        System.out.println(A.name);
        System.out.println(B.address);
    }
}


class A {
    // 类变量的访问，必须遵守 相关的访问权限
    public static String name = "Hello World";
}

class B {
    public static String address = "Shenzhen, China";
}