package com.iamhotcenplotz.chapter17.runnable01_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Cat2 implements Runnable {
    @Override
    public void run() {
        int cnt = 0;

        while (cnt < 80){
            System.out.println((++cnt) + " " + "Hi~");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
