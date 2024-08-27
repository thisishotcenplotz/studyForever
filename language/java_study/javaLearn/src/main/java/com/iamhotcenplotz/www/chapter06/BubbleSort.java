package com.iamhotcenplotz.www.chapter06;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {24, 69, 80, 57, 13,555,666,43424,23545};
        int[] arr2 = {24, 69, 80, 57, 13,555,666,43424,23545};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                if (arr2[j] > arr2[i]) {
                    int tmp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = tmp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

    }
}
