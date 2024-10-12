package com.iamhotcenplotz.www.chapter08.polymorphism_;

public class Poly01 {
    public static void main(String[] args) {

        Master zhangSan = new Master("zhang san");

        zhangSan.feed(new Dog("dog 1"),new Bone("bone 1"));

        zhangSan.feed(new Cat("cat 1"),new Fish("fish 1"));

        zhangSan.feed(new Dog("dog 2"),new Fish("fish 2"));

        zhangSan.feed(new Cat("dog 2"),new Bone("bone 2"));

        zhangSan.feed(new Pig("pig 1"),new Rice("rice 1"));
    }
}
