package com.iamhotcenplotz.www.chapter08.extend_;

/**
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();// new 之后，内存到底发生了什么？

        // 1. 先看子类是否有该属性
        // 2. 如果子类有这个属性，并且可以访问，则返回信息
        // 3. 如果子类没有这个属性，就看父类有没有这个属性，并且如果可以访问就返回信息。
        // 4. 如果父类没有就按照 step 3. 的逻辑继续向上找，一直找到Object类
        System.out.println(son.name);
        System.out.println(son.age);
        System.out.println(son.hobby);
    }
}


class GrandPa {
    String name = "爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa {
    String name = "爸爸";
    int age = 39;
}

class Son extends Father {
    String name = "儿子";
}