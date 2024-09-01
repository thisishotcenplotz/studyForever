package com.iamhotcenplotz.www.chapter07;

public class Puzzle {
    public static void main(String[] args) {
        // 1. 用二维数组创建 8 * 7 的迷宫
        // 2. 0 表示可以走，1 表示障碍物，

        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        // solve
        Solve solve = new Solve();
        solve.fineWay(map,1,1);


        // 打印地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class Solve {
    //使用递归回溯的思想来解决

    //专门找出迷宫的路径的
    // 初始位置为(1,1)
    // 2 表示可以走的路，3 表示走过但走不通。
    // 当map(6,5)== 2 时候，表示走通了，否则继续找。
    // 找路策略：下 -> 右 -> 上 -> 左
    public boolean fineWay(int[][] map,int i,int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;

                // 使用找路策略
                if(fineWay(map,i+1,j)){
                    return true;
                } else if (fineWay(map,i,j+1)) {
                    return true;
                } else if (fineWay(map,i-1,j)) {
                    return true;
                }else if (fineWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
