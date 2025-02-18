package com.iamhotcenplotz.chapter06;

public class ChapterExercise {
    public static void exercise01() {
        int[] arr = {10, 12, 45, 90};
        int num = 23;
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num && arr[i + 1] > num) {
                idx = i + 1;
                break;
            }
        }

        int[] newArr = new int[arr.length + 1];

        newArr[idx] = num;
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i != idx) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = num;
            }
        }

        // print result
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }
    }

    public static void exercise02() {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void exercise03() {
        // bubble sort
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000 + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        // bubble sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }


    }

    public static void exercise04() {
    }

    public static void exercise05() {
    }

    public static void exercise06() {
    }

    public static void main(String[] args) {
//        exercise01();
//        exercise02();
        exercise03();
//        exercise04();


    }
}
