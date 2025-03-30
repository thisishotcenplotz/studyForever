package com.iamhotcenplotz.chapter20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

// 为了让Panel不停地重绘子弹，需要将Panel实现Runnable接口，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {

    // define tank
    Hero hero = null;

    int enemySize = 10;
    Vector<EnemyTank> enemyTanks = new Vector<>();

    // define a vector for store bombs...
    Vector<Bomb> bombs = new Vector<>();

    // define three stages of explosion.


    public MyPanel() {
        //tank initial position
        hero = new Hero(240, 400);

        // enemy tanks
        for (int i = 0; i < enemySize; i++) {
            // 创建敌人坦克
            EnemyTank enemyTank = new EnemyTank(60 * (i + 1), 0);

            // 将enemyTanks 设置给enemyTank
            enemyTank.setEnemyTanks(enemyTanks);

            // 设置方向
            enemyTank.setDirect(2);

            // 启动
            new Thread(enemyTank).start();


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

        // draw hero tank
        if(hero.isAlive()){
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }

        // enemy tank
        Iterator<EnemyTank> enemyTankIterator = enemyTanks.iterator();
        while (enemyTankIterator.hasNext()){
            EnemyTank e = enemyTankIterator.next();
            if(
                hero.getShot() != null &&
                hero.getShot().isAlive() &&
                hero.getShot().getX() > e.getX() &&
                hero.getShot().getX() < e.getX() + 40 &&
                hero.getShot().getY() > e.getY() &&
                hero.getShot().getY() < e.getY() + 40
            ){
                bombs.add(new Bomb(e.getX() + 20, e.getY() + 20));
                enemyTanks.remove(e);
                hero.getShot().dead();

            }

            // 当敌人坦克是活的才去画
            if(e.isAlive()) {
                drawTank(e.getX(), e.getY(), g, e.getDirect(), 0);

                // 画出所有子弹
                for (int j = 0; j < e.shorts.size(); j++) {
                    Short aShort = e.shorts.get(j);

                    // 绘制子弹
                    if (aShort.isAlive()) {
                        g.fill3DRect(aShort.getX(), aShort.getY(), 5, 5, false);
                    } else {
                        e.shorts.remove(j);
                    }
                }
            } else {
                //移除已经爆了的敌人坦克
                enemyTankIterator.remove();
            }
        }

        //draw hero bullet
        if (hero.getShot() != null && hero.getShot().isAlive() && hero.isAlive()) {
            g.fill3DRect(hero.getShot().getX(), hero.getShot().getY(), 5, 5, false);
        }

        // draw explosion
        Iterator<Bomb> bombsIterator = bombs.iterator();
        while (bombsIterator.hasNext()){
            Bomb bomb = bombsIterator.next();
            bomb.draw(g);
            if(!bomb.isAlive()){
                bombsIterator.remove();
            }
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


    // 编写方法，判断我放子弹是否集中敌人的坦克。
    // 什么时候判断我方子弹是否击中敌人坦克 --> run()
    public void hitTank(Short s, Tank tank){
        // 判断s击中坦克
        switch (tank.getDirect()){
            case 0:
            case 2:
                if(
                    (s.getX() > tank.getX() && s.getX() < tank.getX() + 40 )
                    &&
                    (s.getY() > tank.getY() && s.getY() < tank.getY() + 60)
                ){
                    s.dead();
                    tank.dead();

                    // 创建bomb
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                }
                break;
            case 1:
            case 3:
                if(
                    (s.getX() > tank.getX() && s.getX() < tank.getX() + 60)
                    &&
                    (s.getY() > tank.getY() && s.getY() < tank.getY() + 40)
                ){
                    s.dead();
                    tank.dead();

                    // 创建bomb
                    bombs.add(new Bomb(tank.getX(), tank.getY()));
                }
                break;
        }
    }

    // 判断敌方子弹是否击中玩家坦克
    public void hitHero() {
        Iterator<EnemyTank> enemyTankIterator = enemyTanks.iterator();
        while (enemyTankIterator.hasNext()) {
            EnemyTank enemy = enemyTankIterator.next();

            Iterator<Short> enemyShortsIterator = enemy.shorts.iterator();
            while (enemyShortsIterator.hasNext()) {
                Short s = enemyShortsIterator.next();
                if (hero.isAlive() && s.isAlive()) {
                    hitTank(s, hero);
                }
            }
        }
    }

    public void hitEnemy() {
        if(hero.getShot() != null && hero.getShot().isAlive()){
            for (EnemyTank e : enemyTanks){
                hitTank(hero.getShot(),e);
            }
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

            if(hero.getY() > 10){
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if(hero.getY() + 60 < 710){
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if(hero.getX() > 10) {
                hero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if(hero.getX() + 60 < 990){
                hero.moveRight();
            }
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


            //判断我方子弹是否击中敌方坦克
            hitEnemy();

            // 判断敌人坦克是否击中Hero
            hitHero();


            // repaint
            this.repaint();
        }
    }
}
