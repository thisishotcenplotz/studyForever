package com.iamhotcenplotz.chapter17.multiple_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SayHello implements Runnable {
    @Override
    public void run() {
        int cnt = 0;

        while (cnt < 100){
            System.out.println((++cnt) + " Hello~~~");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
