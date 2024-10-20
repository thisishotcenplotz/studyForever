package com.iamhotcenplotz.www.chapter10.innerclass_;

/**
 * 演示局部内部类的使用
 */


public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02 {
    private int n1 = 100;
    private void m2(){

    }
    public void m1(){
        // 局部内部类
        // 作用域仅在方法体内或代码块内
        // 不能使用访问修饰符，但是可以用final
        class Inner02 {
            private int n1 = 200;
            // 可以直接访问外部类的所有成员
            public void f1(){
                System.out.println("Inner n1 = " + n1);
                System.out.println("Outer n1 = " + Outer02.this.n1);
                m2();
            }
        }

        // 外部类在方法中，可以实例化内部类，然后调用方法即可。
        Inner02 inner02 = new Inner02();
        inner02.f1();


    }
}


