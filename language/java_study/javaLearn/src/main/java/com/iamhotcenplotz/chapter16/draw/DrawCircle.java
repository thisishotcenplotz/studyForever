package com.iamhotcenplotz.chapter16.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * show how to draw a circle on panel
 */

// JFrame 对应一个窗口
public class DrawCircle extends JFrame{

    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        mp = new MyPanel();

        // 把面板放入到窗口
        this.add(mp);

        // 设置窗口大小
        this.setSize(400,300);

        // 设置自动结束程序
        // 当关闭画板时
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 可视
        this.setVisible(true);


    }
}

// step 1: define a panel
// MyPane 继承自 Jpanel

class MyPanel extends JPanel {

    // consider Graphics as a pen
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类方法，完成初始化

        g.drawOval(10,10,100,100);

        // show draw methods
//        g.drawLine(10,10,110,110);

//        g.drawRect(10,10,100,100);

//            g.setColor(Color.BLACK);
//            g.fillRect(10,10,110,110);

//        g.setColor(Color.cyan);
//        g.fillOval(10,10,100,100);

//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/"));
//        g.drawImage(image, 0, 0, this);

//        g.setColor(Color.BLACK);
//        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        g.drawString("Hello World",30,30);

    }

}
