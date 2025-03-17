package com.iamhotcenplotz.chapter17.thread01_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ThreadDemo01_ {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        // 当main线程启动一个子线程 Thread-0, 主线程不会阻塞，会继续执行。
        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i + " " + Thread.currentThread().getName());
            Thread.sleep(100);
        }
    }
}
