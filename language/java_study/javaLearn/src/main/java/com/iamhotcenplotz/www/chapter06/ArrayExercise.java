package com.iamhotcenplotz.www.chapter06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercise {
    public static void introToArray() {
        double c1 = 1.0;
        double c2 = 2.0;

        double avgWeight = (c1 + c2) / 2;
        System.out.println(avgWeight);
    }

    public static void exercise01() {
        double[] chickens = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        double totalWeight = 0.0;
        for (int i = 0; i < chickens.length; i++) {
            System.out.println(chickens[i]);
            totalWeight += chickens[i];
        }

        System.out.println(Arrays.stream(chickens).sum());
        System.out.println(Arrays.stream(chickens).average());
        System.out.println(totalWeight / 6);
    }

    public static void arrayInitialization01() {
        Scanner scanner = new Scanner(System.in);

        double[] scores = new double[5];

        for (int i = 0; i < scores.length; i++) {
            System.out.print("enter:");
            scores[i] = scanner.nextDouble();
            System.out.println();
        }
    }

    public static void arrayInitialization02() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void arrayDetail() {
    /*
    *
    1. 数组是多个相同类型数据的组合，实现对这些数据的统一管理
    2. 数组中的元素可以使任何数据类型，包括基本类型和引用类型，但是不能混用
    3. 数组创建后，如果没有赋值则使用默认值

    - int：0
    - short：0
    - byte：0
    - long：0
    - float：0.0
    - double：0.0
    - char：\u0000
    - boolean: false
    - String: null

    4. 数组的的步骤：声明数组并开辟空间 --> 给数组各个元素赋值 --> 使用数组
    5. 数组的下表从0开始
    6. 数组下表必须在指定范围内使用，否则报错：下表越界异常。
    7. 数组属于引用数据类型，数组型数据是对象（object）*/
//        int[] arr1 = {1,2,3,4,5,6,1,1}; 会报错。不能赋值高精度的；低精度给高精度可以。
    }

    public static void arrayExercise01() {
        char init = 'A';
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {

            alphabet[i] = (char) (init + i);

        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i]);
        }
    }

    public static void arrayExercise02() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9,-1};
        int maxNum = data[0];
        int maxNumIdx = 0;

        int minNum = data[0];
        int minNumIdx = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxNum) {
                maxNum = data[i];
                maxNumIdx = i;
            }

            if (data[i] < minNum) {
                minNum = data[i];
                minNumIdx = i;
            }
        }
        System.out.println(maxNum+" "+maxNumIdx);
        System.out.println(minNum+" "+minNumIdx);
    }

    public static void arrayAssign01() {
        // 基本数据类型赋值，赋值方式是值拷贝。
        // 数组在默认情况下是引用传递，赋的值是地址，赋值方式为引用

        int[] a1 = {1,2,3};
        int[] a2 = a1;
        a2[2] =4;

        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i] + " " + a2[i]);
        }

    }
    public static void arrayCopy(){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public static void arrayReverse(){
        int[] arr = {11,22,33,44,55,66};
        int[] rst = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            rst[arr.length-i-1] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(rst[i]);
        }
        System.out.println();
        for (int i = 0; i < arr.length/2; i++) {
            int tmp = arr[i];
            int left = arr[i];
            int right = arr[arr.length-i-1];

            arr[i] = right;
            arr[arr.length-1-i] = tmp;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
//        exercise01();
//        arrayInitialization01();
//        arrayInitialization02();
//        arrayExercise01();
//        arrayExercise02();
//        arrayAssign01();
        arrayReverse();
    }


}
