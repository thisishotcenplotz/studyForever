package com.iamhotcenplotz.chapter17.methods_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Methods01_ {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo01());
        thread.setName("zhang san");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Hi..." + i);
        }
        // 当执行到这里时，就会中断Demo01 的休眠。
        thread.interrupt();
    }
}


class Demo01 implements Runnable {

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i + "chi bao zi ...");
            }
            try {
                System.out.println(Thread.currentThread().getName() + " sleep....");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                // InterruptedException 是捕获到了一个中断异常。不是终止异常。。。
                System.out.println(Thread.currentThread().getName() + " interrupted ...");
            }
        }
    }
}