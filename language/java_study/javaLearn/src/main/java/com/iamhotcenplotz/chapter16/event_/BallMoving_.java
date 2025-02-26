package com.iamhotcenplotz.chapter16.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示小球上下左右移动，-> 讲解Java事件控制
 */
public class BallMoving_ extends JFrame{
    private BallPanel mp = null;

    public BallMoving_() {
        BallPanel ballPanel = new BallPanel();

        this.add(ballPanel);

        this.setSize(400,300);

        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        BallMoving_ ballMoving = new BallMoving_();


    }
}

class BallPanel extends JPanel implements KeyListener {

    private int x= 10;
    private int y= 10;

    public BallPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillOval(x,y,20,20);

    }


    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 当某个键按下去的时候，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char)e.getKeyCode() + "被按下...");

        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            y+=5;
            System.out.println(x + "," + y);
        }else if(e.getKeyCode() == KeyEvent.VK_UP) {
            y-=5;
            System.out.println(x + "," + y);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x-=5;
            System.out.println(x + "," + y);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x+=5;
            System.out.println(x + "," + y);
        }

        this.repaint();
    }

    // 当某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
