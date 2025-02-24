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

    /**
     * @param x
     * @param y
     * @param g graphics
     * @param direct up down left right
     * @type type color
     * */
    public void drawTank(int x,int y,Graphics g, int direct,int type){

        //  设置颜色
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }


        switch (direct){
            case 0:
                
            default:
                System.out.println("...");
        }




    }
}
