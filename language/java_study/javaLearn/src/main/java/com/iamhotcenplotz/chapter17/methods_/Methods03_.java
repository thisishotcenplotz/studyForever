package com.iamhotcenplotz.chapter17.methods_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Methods03_ {
    public static void main(String[] args) throws InterruptedException{
        Thread daemon = new Thread(new SomeDaemonThread());

        // 设置daemon为守护线程，即当主线程结束后，daemon线程也会结束。
        daemon.setDaemon(true);

        daemon.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Attention... Spark is running...");
            Thread.sleep(1000);
        }
    }
}


class SomeDaemonThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Oops~~~ Flink is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}