package com.iamhotcenplotz.chapter08.polymorphism_.objpoly_;

public class PolyObject {
    public static void main(String[] args) {

        // 编译类型 Animal，运行类型是Dog
        Animal dog = new Dog();

        Animal cat = new Cat();

        // 会调用运行类型的具体方法
        dog.cry();
        cat.cry();
    }
}
