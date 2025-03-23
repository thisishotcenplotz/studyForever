package com.iamhotcenplotz.chapter18;

import java.awt.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * <p>
 * 炸弹
 */
public class Bomb {
    private int x, y;
    private int life = 9; // 炸弹的声明周期
    private boolean isAlive = true;
    private int step = 0;

    public boolean isAlive() {
        return isAlive;
    }

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void leftDown() {
        if (life > 0) life--;
        else isAlive = false;
    }

    public void draw(Graphics g) {
        if (!isAlive) return;

        if (step < 6) {
            if (step % 2 == 0) {
                g.setColor(Color.RED);
                g.fillOval(x + 10, y + 10, 40, 40);
            }
            step++;
        } else {
            isAlive = false;
        }
    }


}
