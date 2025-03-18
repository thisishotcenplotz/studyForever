package com.iamhotcenplotz.chapter17.exercise_.exit_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();

        Thread.sleep(1000 * 10);

        t.setLoop(false);


    }
}


/* 通知方式 */
class T implements Runnable {
    private int count = 0;

    private boolean loop = true;

    public boolean getLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println("A Thread is running...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
