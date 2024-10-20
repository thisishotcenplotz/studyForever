package com.iamhotcenplotz.www.chapter10.block_;

/**
 * 静态代码块被调用的示例
 */

public class Detail01 {
    public static void main(String[] args) {

        // 1. 创建对象实例时
        AA aa = new AA();


        // 2. 创建子类对象实例时，父类也会被加载
        BB bb = new BB();

        // 3. 使用类的静态成员时
        System.out.println(Cat.age);
    }
}

class AA {
    static {
        System.out.println("AA static block...");
    }
}


class BB extends AA {
    static {
        System.out.println("BB static block...");
    }
}

class Cat {
    public static int age = 999;

    static {
        System.out.println("Cat static block...");
    }
}