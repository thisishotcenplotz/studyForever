package com.iamhotcenplotz.chapter16.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class MyPanel extends JPanel implements KeyListener {

    // define tank
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.addKeyListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw tank
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
//        drawTank(hero.getX()+120, hero.getY(), g, hero.getDirect(), 1);
//        drawTank(hero.getX()+240, hero.getY(), g, hero.getDirect(), 0);
//        drawTank(hero.getX()+360, hero.getY(), g, hero.getDirect(), 1);

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


        //根据坦克方向，绘制对应形状坦克
        // direct: 0 -> up ; 1 -> right ; 2 -> down ; 3 -> left
        switch (direct) {
            case 0:  // up
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 20, x + 20, y);
                break;
            case 1: // right
                g.fill3DRect(x, y, 60, 10, false); // 上轮
                g.fill3DRect(x, y + 30, 60, 10, false); // 下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 圆盖
                g.drawLine(x + 20, y + 20, x + 60, y + 20); // 炮筒
                break;
            case 2: // down
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 20, x + 20, y+60);
                break;
            case 3: // left
                g.fill3DRect(x, y, 60, 10, false); // 上轮
                g.fill3DRect(x, y + 30, 60, 10, false); // 下轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 圆盖
                g.drawLine(x + 20, y + 20, x, y + 20); // 炮筒
                break;
            default:
                System.out.println("...");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    // 处理 wsad  -> up down left right
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            //修改方向
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
