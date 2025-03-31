package com.iamhotcenplotz.chapter20;

import java.io.*;
import java.util.Vector;

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
    private static BufferedReader br = null;

    private static String recordPath = "tankGame.txt";

    public static String getRecordPath() {
        return recordPath;
    }

    //nodes
    private static Vector<Node> nodes = new Vector<>();

    // define enemy tanks
    private static Vector<EnemyTank> enemyTanks = null;

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankCount() {
        return allEnemyTankCount;
    }

    public static void setAllEnemyTankCount(int allEnemyTankCount) {
        Recorder.allEnemyTankCount = allEnemyTankCount;
    }

    public static void hitEnemy(){
        Recorder.allEnemyTankCount ++;
    }

    // 恢复Nodes
    public static Vector<Node> getNodesAndEnemyTankRec() throws IOException{
        br = new BufferedReader(new FileReader(recordPath));
        // enemy counts
        allEnemyTankCount = Integer.parseInt(br.readLine());

        // Nodes..
        String line;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(" ");
            nodes.add(new Node(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2])));
        }

        // close
        if(br != null){
            br.close();
        }

        return nodes;
    }

    public static void persist() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordPath));

        bw.write(String.valueOf(allEnemyTankCount));
        bw.newLine();

        // iterate enemy tanks vector, then save is alive.
        for (EnemyTank e : Recorder.enemyTanks){
            if(e.isAlive()){
                bw.write(e.getX() + " " + e.getY() + " " + e.getDirect());
                bw.newLine();
            }
        }

        if (bw != null) {
            bw.close();
        }
    }
}
