package com.iamhotcenplotz.chapter17.deadlock_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 模拟线程死锁的情况
 */
public class DeadLockDemo_ {
    public static void main(String[] args) {
        // Deadlock simulation
        DeadLockDemo demo1 = new DeadLockDemo(true);
        DeadLockDemo demo2 = new DeadLockDemo(false);

        demo1.start();
        demo2.start();
    }
}


class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        // 1. 如果flag，线程就会先持有 O1， 然后尝试去获取O2 对象锁
        // 如果得不到O2，就会blocked
        // 2. 如果不是flag，线程就会先持有O2， 然后尝试去获取O1对象锁
        // 如果拿不到O1对象锁，也会Blocked
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " Enter 1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " Enter 2");
                }
            }
        } else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName() + " Enter 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " Enter 4");
                }
            }
        }
    }


}