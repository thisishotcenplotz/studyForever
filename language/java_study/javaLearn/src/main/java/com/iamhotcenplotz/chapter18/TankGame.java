package com.iamhotcenplotz.chapter18;

import javax.swing.*;
import java.awt.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class TankGame extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {

        TankGame tankGame01 = new TankGame();
    }

    public TankGame() throws HeadlessException {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
