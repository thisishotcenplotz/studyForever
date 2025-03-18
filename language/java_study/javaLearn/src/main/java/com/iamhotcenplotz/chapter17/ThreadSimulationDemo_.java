package com.iamhotcenplotz.chapter17;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ThreadSimulationDemo_ implements Runnable {
    private Runnable target = null;

    @Override
    public void run() {
        if(target != null) {
            target.run();
        }
    }

    public ThreadSimulationDemo_(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}
