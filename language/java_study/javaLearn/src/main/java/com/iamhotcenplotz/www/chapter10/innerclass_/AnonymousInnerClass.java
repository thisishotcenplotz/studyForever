package com.iamhotcenplotz.www.chapter10.innerclass_;
/**
 * 演示匿名内部类
 * */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {
    private int n1 = 10;

    public void method() {
        // 基于接口的匿名内部类
        // 1. 需求：向使用IA接口并创建一个对象
        // 2. 传统方式，写一个类然后实现该接口，并创建对象
        // 3. 新方法 使用匿名内部类来简化开发

        /*
            类名就叫： Outer04$1
            底层：
            class XXX implements IA {
                @Override
                public void cry(){
                    System.out.println("老虎嗷嗷..")
                }
            }

            jdk在底层在创建完内部类 立刻马上就 将这个类 实例化了，然后把地址返回给了tiger
        */
        IA tiger = new IA() {
            // 编译类型是IA
            // 运行类型是匿名内部类
            @Override
            public void cry() {
                System.out.println("老虎嗷嗷...");
            }
        };
        IA dog = new IA() {
            @Override
            public void cry() {
                System.out.println("小狗旺旺...");
            }
        };
        System.out.println("tiger 的运行类型" + tiger.getClass());
        tiger.cry();
        System.out.println("dog 的运行类型" + dog.getClass());
        dog.cry();

        // 基于类的匿名内部类
        Human somebody = new Human("somebody"){
            @Override
            public void test() {
                System.out.println("human override test method");
            }
        };
        System.out.println("somebody 的运行类型" + somebody.getClass());
        somebody.test();

        Animal cat = new Animal() {

            @Override
            void eat() {
                System.out.println("Cat is eatting...");
            }
        };
        System.out.println("cat 的运行类型" + cat.getClass());
        cat.eat();


    }
}

interface IA {
    void cry();
}

class Human {
    public Human(String name) {
        System.out.println("name = " + name);
    }

    public void test(){

    }
}

abstract class Animal {
    abstract void eat();
}