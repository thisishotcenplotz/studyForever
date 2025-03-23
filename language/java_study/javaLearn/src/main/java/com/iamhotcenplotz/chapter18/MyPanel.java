package com.iamhotcenplotz.chapter18;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

// 为了让Panel不停地重绘子弹，需要将Panel实现Runnable接口，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {

    // define tank
    Hero hero = null;

    int enemySize = 3;
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public MyPanel() {
        //tank initial position
        hero = new Hero(240, 400);

        // enemy tanks
        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank(120 * (i + 1), 0);
            enemyTank.setDirect(2);


            Short aShort = new Short(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shorts.add(aShort);
            new Thread(aShort).start();


            enemyTanks.add(enemyTank);

        }


        // tank moving speed
        hero.setSpeed(2);


        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocusInWindow();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw tank
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        // enemy tank
        for (EnemyTank e : enemyTanks) {
            drawTank(e.getX(), e.getY(), g, 2, 0);

            // 画出所有子弹
            for (int j = 0; j < e.shorts.size(); j++) {
                Short aShort = e.shorts.get(j);

                // 绘制子弹
                if(aShort.isAlive()){
                    g.fill3DRect(aShort.getX(),aShort.getY(),5,5,false);
                } else {
                    e.shorts.remove(j);
                }
            }
        }

        //draw hero bullet
        if (hero.getShot() != null && hero.getShot().isAlive()) {
            g.fill3DRect(hero.getShot().getX(), hero.getShot().getY(), 5, 5, false);
        }

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
                g.drawLine(x + 20, y + 20, x + 20, y + 60);
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
        if (e.getKeyCode() == KeyEvent.VK_W) {
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

        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("Shoot enemy tank ...");
            hero.shootEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            this.repaint();
        }

    }
}
