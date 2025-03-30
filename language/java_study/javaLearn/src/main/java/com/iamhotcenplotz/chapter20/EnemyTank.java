package com.iamhotcenplotz.chapter20;

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

    // EnemyTank 可以得到所有敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();

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


    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }


    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克发生了重叠或碰撞

    public boolean isOverlapEnemyTanks() {
        switch (this.getDirect()) {
            case 0: // up
                // 让当前的敌人坦克和其他所有的敌人坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 先取出一个敌人
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {

                        // 如果敌人坦克时 up/down
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            // 敌人坦克 -> x:[x,x+40] ; y:[y,y + 60]
                            // 当前坦克 -> x:[x,y] ; y: [x+40,y]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }

                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                        }


                        // 如果敌人坦克是left/right
                        // e -> x:[e.x, e.x + 60]; y:[e.y, e.y + 40]
                        // this -> [x + 40, y]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                        }


                    }
                }
                break;
            case 1: // right
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 先取出一个敌人
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {

                        // 如果敌人坦克时 up/down
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            // 敌人坦克 -> x:[x,x+60] ; y:[y,y]
                            // 当前坦克 -> x:[x,y] ; y: [x+40,y]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }

                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                        }


                        // 如果敌人坦克是left/right
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {

                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                        }


                    }
                }
                break;
            case 2: // down
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 先取出一个敌人
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {

                        // 如果敌人坦克时 up/down
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }

                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                        }


                        // 如果敌人坦克是left/right
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                        }

                    }
                }
                break;
            case 3: //left
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 先取出一个敌人
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {

                        // 如果敌人坦克时 up/down
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60
                            ) {
                                return true;
                            }
                        }


                        // 如果敌人坦克是left/right
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }

                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40
                            ) {
                                return true;
                            }
                        }

                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {

        while (true) {
            // 判断是否还有子弹,如果没有再建一个
            if (shorts.size() < 2 && isAlive) {
                Short s = null;
                switch (getDirect()) {
                    case 0:
                        s = new Short(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Short(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Short(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Short(getX(), getY() + 20, 3);
                        break;
                }
                shorts.add(s);
                new Thread(s).start();
            }


            // 根据坦克方向继续移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 50; i++) {
                        if (getY() > 0 && !isOverlapEnemyTanks()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 50; i++) {
                        if (getX() + 60 < 990 && !isOverlapEnemyTanks())  {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {
                        if (getY() + 60 < 740 && !isOverlapEnemyTanks()) {
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 50; i++) {

                        if (getX() > 10 && !isOverlapEnemyTanks()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
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
