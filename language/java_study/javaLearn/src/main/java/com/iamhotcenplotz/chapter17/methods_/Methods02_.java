package com.iamhotcenplotz.chapter17.methods_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Methods02_ {
    public static void main(String[] args) throws InterruptedException {
        // main线程创建一个子线程，每个1秒输出hello，输出20次，
        // 主线程每隔1秒输出hi，输出20次
        // 要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续

        Thread thread = new Thread(new SubThread());
        thread.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            // if( i == 5) thread.join(); // 让thread 插队，直至thread全部执行完毕后，main再继续。
            if( i == 5) Thread.yield(); // 让主线程礼让 子线程。如果资源特别丰富，则可能礼让失败。

            System.out.println("Main Thread: " + i);
        }
    }
}

class SubThread implements Runnable {
    private int cnt = 20;
    @Override
    public void run() {
        while (cnt > 0) {
            System.out.println("SubThread:" + " " + cnt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            cnt --;
        }
    }
}
