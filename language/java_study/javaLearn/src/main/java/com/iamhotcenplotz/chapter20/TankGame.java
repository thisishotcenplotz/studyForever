package com.iamhotcenplotz.chapter20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

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
        this.setSize(1300, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 在 JFrame 中， 增加响应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("退出游戏...");

                try {
                    Recorder.persist();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                System.exit(0);
            }
        });
    }
}
