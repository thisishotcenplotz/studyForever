package com.iamhotcenplotz.chapter18;

import java.util.Map;
import java.util.Vector;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * <p>
 * 让敌人的坦克也能够发射子弹（可以由多颗子弹）
 * 1. 在敌人坦克类，使用Vector报错多个shot
 * 2. 当每创建一个敌人坦克对象，该敌人坦克对象初始化一个shot对象，同时启动shot
 * 在绘制敌人坦克时，需要变量敌人坦克对象Vector，绘制所有子弹，当子弹isLive == false 时，就从Vector移除
 * <p>
 * 让敌人坦克自由移动：
 * 1. 实现Runnable接口
 */
public class EnemyTank extends Tank implements Runnable {
    // 在敌人坦克类，使用Vector 保存多个Shot
    Vector<Short> shorts = new Vector<>();
    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    public void dead() {
        this.isAlive = false;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {

        while (true) {
            // 根据坦克方向继续移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        } else {
                            moveDown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        } else {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        } else {
                            moveUp();
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {

                        if (getX() > 0) {
                            moveLeft();
                        } else {
                            moveRight();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    break;
            }


            // 然后随机的改变一下坦克方向
            setDirect((int) (Math.random() * 4));

            // break the thread when enemy tank dead
            if (!isAlive) break;
        }
    }
}
