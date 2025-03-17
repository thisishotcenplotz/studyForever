package com.iamhotcenplotz.chapter17.thread01_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 通过继承Thread类 创建线程
 */

// 当一个类继承Thread类，该类就可以当做线程使用
// 我们会重写run方法，写上自己的业务代码
// run Thread类实现了 Runnable 接口的run方法


public class Cat extends Thread {
    @Override
    public void run() {
        int cnt = 0;
        while (cnt < 80) {
            System.out.println((++cnt) +" Hello Scala World... " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
