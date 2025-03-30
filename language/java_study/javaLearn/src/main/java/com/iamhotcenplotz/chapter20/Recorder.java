package com.iamhotcenplotz.chapter20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 用于记录相关信息，会和文件交互。
 */
public class Recorder {

    //定义变量，记录我方击毁敌方坦克数量
    private static int allEnemyTankCount = 0;
    // 定义IO对象, 用于写数据到文件中
    private static BufferedWriter bw = null;
    private static String recordPath = "tankGame.txt";

    public static int getAllEnemyTankCount() {
        return allEnemyTankCount;
    }

    public static void setAllEnemyTankCount(int allEnemyTankCount) {
        Recorder.allEnemyTankCount = allEnemyTankCount;
    }

    public static void hitEnemy(){
        Recorder.allEnemyTankCount ++;
    }

    public static void persist() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordPath, true));

        bw.write(allEnemyTankCount);
        bw.newLine();

        if (bw != null) {
            bw.close();
        }
    }
}
