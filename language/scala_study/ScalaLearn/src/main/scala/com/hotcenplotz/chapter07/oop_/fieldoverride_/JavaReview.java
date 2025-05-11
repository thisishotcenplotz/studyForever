package com.hotcenplotz.chapter07.oop_.fieldoverride_;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-12 06:40
 * @description:
 */


public class JavaReview {
    public static void main(String[] args) {
        // 创建两个对象
        // 下面的代码小结
        // 1. 对于同一个对象，用父类的引用去取值，会取到父类的字段的值
        // 2. 用子类的引用去取值，则取到子类的值
        SubJava subJava = new SubJava();
        SuperJava subJava1 = new SubJava();

        System.out.println(subJava1.s);
        System.out.println(subJava.s);

        // Java 动态绑定小结
        // 1. 如果调用的是方法，则JVM会将该方法的内存地址绑定
        // 2. 如果调用的是一个属性，则没有动态绑定，在哪里调用，就返回对应的值


    }
}


class SuperJava {
    String s = "super";
}

class SubJava extends SuperJava {
    String s = "sub";
}