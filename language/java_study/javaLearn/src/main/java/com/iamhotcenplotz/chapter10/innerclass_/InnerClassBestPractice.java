package com.iamhotcenplotz.chapter10.innerclass_;
/**
 * 匿名内部类最佳实践
 * - 把它当做实参直接传递，简单高效
 */

public class InnerClassBestPractice {

    public static void main(String[] args) {
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("Hello World");
            }
        });
    }

    // 形参是接口类型
    public static void f1(IL il){
        il.show();
    }
}

interface IL {
    void show();
}
