package com.iamhotcenplotz.chapter18;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 发射子弹
 */
public class Short implements Runnable {
    private int x; // x-axis
    private int y; // y-axis
    private int direct = 0;
    private int speed = 2;

    private boolean isAlive = true;

    public Short(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void dead(){
        isAlive = false;
    }


    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            // 根据方向来改编x，y
            switch (direct) {
                case 0: // up
                    y -= speed;
                    break;
                case 1: // right
                    x += speed;
                    break;
                case 2: // down
                    y += speed;
                    break;
                case 3: // left
                    x -= speed;
                    break;
            }

            // print bullet position for test
//            System.out.println(Thread.currentThread().getName()+ " bullet position: [" + x + "," + y + "]");

            // 挡子弹碰到敌人坦克时，也应该退出
            if (!(x >= 0 && y <= 1000 && y >= 0 && y <=750 && isAlive)) {
                isAlive = false;
                break;
            }
        }
    }
}
