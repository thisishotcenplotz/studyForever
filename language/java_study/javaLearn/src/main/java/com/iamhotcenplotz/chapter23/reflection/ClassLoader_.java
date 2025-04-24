package com.iamhotcenplotz.chapter23.reflection;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ClassLoader_ {
}

class LoadingPreparation {
    // 属性-成员变量-字段
    // 类加载的链接阶段-准备 属性是如何处理
    // 1. n1 是属性实例，不是静态变量，因此在准备阶段，是不会分配内存的
    // 2. n2 是静态变量，分配内存，n2默认初始化为0，而不是20
    // 3. n3 是static final 是常量，它和静态变量不一样，因为一旦赋值就不变，所以直接就是 n3 = 30

    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;
}

class Initialization {
    // 1. 加载B类，并生成B的class对象
    // 2. 链接num = 0
    // 3. 初始化阶段
    //       - 依次自动收集类中所有的静态变量的赋值动作和静态代码块中的语句, 并合并
                /*    clinit() {
                        System.out.println("静态代码块");
                        //num = 300;
                        num = 100;
                    }
                    合并： num = 100
                */
    // 4. 构造器

    static {
        System.out.println("静态代码块");
        num = 300;
    }

    static int num = 100;

    public Initialization(){
        System.out.println("构造器");
    }
}
