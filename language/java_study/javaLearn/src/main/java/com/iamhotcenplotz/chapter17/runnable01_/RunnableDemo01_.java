package com.iamhotcenplotz.chapter17.runnable01_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class RunnableDemo01_ {
    public static void main(String[] args) {
        Thread thread = new Thread(new Cat2());
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(i+" main~~~");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
