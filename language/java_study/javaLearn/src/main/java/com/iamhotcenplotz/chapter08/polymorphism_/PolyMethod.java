package com.iamhotcenplotz.chapter08.polymorphism_;

public class PolyMethod {
    public static void main(String[] args) {
        // 方法重载体现多态
        A a = new A();

        // 这里传入不同的参数，就会调用不同的sum方法。体现了方法的多态
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10, 20, 30));

        // 方法的重写体现了多态
        B b = new B();
        b.say();
        a.say();
    }
}

class B {
    public void  say(){
        System.out.println("Calling B.say()...");
    }
}

class A extends B {
    public int sum(int n1, int n2){
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3){
        return n1 + n2 + n3;
    }

    @Override
    public void say() {
        System.out.println("Calling A.say()...");
    }
}
