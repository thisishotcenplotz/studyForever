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
        hero = new Hero(100,100);
    }

    @Override
    public void print(Graphics g) {
        super.print(g);

        g.fillRect(0,0,1000,750);
    }
}
