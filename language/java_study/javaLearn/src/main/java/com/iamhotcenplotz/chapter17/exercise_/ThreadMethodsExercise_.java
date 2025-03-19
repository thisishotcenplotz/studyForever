package com.iamhotcenplotz.chapter17.exercise_;

import com.iamhotcenplotz.chapter17.multiple_.SayHello;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ThreadMethodsExercise_ {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new sayHello());

        int cnt = 10;
        while (cnt > 0) {
            System.out.println("Maintask: hi~ "+cnt);
            if(cnt == 5) {
                thread.start();
                thread.join();
            }

            Thread.sleep(1000);
            cnt --;
        }
    }
}

class sayHello implements Runnable{
    private int cnt = 10;

    @Override
    public void run() {
        while (cnt > 0) {
            System.out.println("Subtask: hello~ " + cnt);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            cnt --;
        }
    }
}
