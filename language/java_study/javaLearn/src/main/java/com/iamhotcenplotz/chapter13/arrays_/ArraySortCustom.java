package com.iamhotcenplotz.chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ArraySortCustom {
    public static void main(String[] args) {
        int[] arr = {1,-2,8,0,20};
//        bubble(arr);
        bubbleCustomize(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1 - (int)o2;
            }
        });

        System.out.println(Arrays.toString(arr));

    }

    // bubble sort
    public static void bubble(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1 -i; j++) {
                // 从小到大
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // bubble + custom

    public static void bubbleCustomize(int[] arr, Comparator<Integer> c){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1 -i; j++) {
                // 从小到大
                if(c.compare(arr[j],arr[j+1]) > 0){ // 决定从小到大还是从大到小
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
