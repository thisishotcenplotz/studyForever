package com.iamhotcenplotz.chapter06;

import java.util.Scanner;

public class TwoDimArray {
    public static void twoDimArray(){
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
    public static void twoDimArrayWithUncertaintyColumnSize(){
        int[][] arrLevelOne = new int[10][];
        for (int i = 0; i < arrLevelOne.length; i++) {
            arrLevelOne[i] = new int[i+1];
            for (int j = 0; j < arrLevelOne[i].length; j++) {
                arrLevelOne[i][j] = i+1;
            }

        }

        for (int i = 0; i < arrLevelOne.length; i++) {
            for (int j = 0; j < arrLevelOne[i].length; j++) {
                System.out.print(arrLevelOne[i][j]+"\t");
            }
            System.out.println();
        }

    }

    public static void pascalTriangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter size: ");
        int size = scanner.nextInt();

        int[][] arr = new int[size][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
//        int[][] arr = {
//                {0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 0, 0},
//                {0, 2, 0, 3, 0, 0},
//                {0, 0, 0, 0, 0, 0}
//        };
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        twoDimArray();
//        twoDimArrayWithUncertaintyColumnSize();

        pascalTriangle();

    }
}
