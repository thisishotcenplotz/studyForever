package com.iamhotcenplotz.chapter18;

import java.util.Vector;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 *
 * 让敌人的坦克也能够发射子弹（可以由多颗子弹）
 * 1. 在敌人坦克类，使用Vector报错多个shot
 * 2. 当每创建一个敌人坦克对象，该敌人坦克对象初始化一个shot对象，同时启动shot
 * 在绘制敌人坦克时，需要变量敌人坦克对象Vector，绘制所有子弹，当子弹isLive == false 时，就从Vector移除
 */
public class EnemyTank extends Tank {
    // 在敌人坦克类，使用Vector 保存多个Shot
    Vector<Short> shorts = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
