package com.iamhotcenplotz.chapter18;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Hero extends Tank {
    // 定义short对象

    private Short shot = null;


    public Hero(int x, int y) {
        super(x, y);
    }

    public Short getShot() {
        return shot;
    }

    public void shootEnemyTank() {
        // create shot object
        switch (getDirect()) {
            case 0:
                this.shot = new Short(getX() + 20, getY(), 0);
                this.shot.setSpeed(this.getSpeed());
                break;
            case 1:
                this.shot = new Short(getX() + 60, getY() + 20, 1);
                this.shot.setSpeed(this.getSpeed());
                break;
            case 2:
                this.shot = new Short(getX() + 20, getY() + 60, 2);
                this.shot.setSpeed(this.getSpeed());
                break;
            case 3:
                this.shot = new Short(getX(), getY() + 20, 3);
                this.shot.setSpeed(this.getSpeed());
                break;
        }

        new Thread(shot).start();

    }
}
