package com.iamhotcenplotz.chapter28;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-30 20:20
 * @description: 体验骑士周游算法
 * 将使用DFS + 贪心
 */


public class KnightsTour {
    // 定义属性
    private static int X = 6; // number of rows
    private static int Y = 6; // number of columns
    private static int[][] board = new int[Y][X];
    private static boolean[] visited = new boolean[Y * X]; //
    private static boolean finished = false; // is horse iterated all spot of the board

    public static void main(String[] args) {
        int row = 2;
        int col = 2;

        // test
        long start = System.currentTimeMillis();
        travels(board,row-1,col-1,1);
        long end = System.currentTimeMillis();
        System.out.println("Duration: " +(end - start) + "ms");

        // board display
        for (int[] rows : board) {
            for (int step : rows) { // representing the number step that the horse walked
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    // get allowed next steps of current position
    public static ArrayList<Point> getNext(Point cur) {
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();

        //is allowed to go 5
        if((p.x = cur.x -2) >= 0 && (p.y = cur.y -1) >= 0) {
            points.add(new Point(p));
        }

        //is allowed to go 6
        if((p.x = cur.x -1) >= 0 && (p.y = cur.y -2) >= 0) {
            points.add(new Point(p));
        }

        //is allowed to go 7
        if((p.x = cur.x +1) < X && (p.y = cur.y-2) >= 0) {
            points.add(new Point(p));
        }

        //is allowed to go 0
        if((p.x = cur.x + 2) < X && (p.y = cur.y-1) >= 0) {
            points.add(new Point(p));
        }

        //is allowed to go 1
        if((p.x = cur.x + 2) < X && (p.y = cur.y+1) < Y) {
            points.add(new Point(p));
        }

        //is allowed to go 2
        if((p.x = cur.x + 1) < X && (p.y = cur.y+2) < Y) {
            points.add(new Point(p));
        }

        //is allowed to go 3
        if((p.x = cur.x - 1) >= 0 && (p.y = cur.y+2) < Y) {
            points.add(new Point(p));
        }

        //is allowed to go 4
        if((p.x = cur.x - 2) >= 0 && (p.y = cur.y+1) < Y) {
            points.add(new Point(p));
        }

        return points;
    }

    // find the minimum steps of next position
    public static void sort(ArrayList<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return getNext(o1).size() - getNext(o2).size();
            }
        });
    }

    // The core iteration algorithm
    // if success then set finished = true
    // and record steps to board
    public static void travels(int[][] board, int row,int col,int step){

        // record step into board first
        board[row][col] = step;

        // add current position to visited
        visited[row * X + col] = true;

        // get next of current position
        ArrayList<Point> nextSteps = getNext(new Point(col, row));
        sort(nextSteps);

        // iterate
        while (!nextSteps.isEmpty()) {

            Point p = nextSteps.remove(0);

            // determine whither p was visited
            // if not then iterate recursively
            if(!visited[p.y * X + p.x]) {
                // recursive iterate
                travels(board, p.y,p.x,step+1);
                if (finished) return;
            }
        }

        // check is iteration success after exit the while loop
        // if not then reset, and trace back
        if(step < X * Y && !finished){
            // reset
            board[row][col] = 0;
            visited[row * X + col] = false;
        } else {
            finished = true;
        }
    }
}
