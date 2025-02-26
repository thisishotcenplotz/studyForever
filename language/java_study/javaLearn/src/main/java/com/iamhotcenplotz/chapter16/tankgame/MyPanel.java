package com.iamhotcenplotz.chapter16.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class MyPanel extends JPanel {

    // define tank
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
        this.setBackground(Color.LIGHT_GRAY);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw tank
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
        drawTank(hero.getX()+120, hero.getY(), g, 0, 1);

    }

    /**
     * @param x
     * @param y
     * @param g      graphics
     * @param direct up down left right
     * @type type color
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //  设置颜色
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }


        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 20, x + 20, y);
                break;
            default:
                System.out.println("...");
                break;
        }
    }
}
