package com.iamhotcenplotz.www.chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Arrays_ {
    public static void main(String[] args) {
        Integer[] ints = {10, 20, 30};

        System.out.println(Arrays.toString(ints));

        Integer[] toSort = {1,10,3,20,5,30,7};

        Arrays.sort(toSort);

        Arrays.sort(toSort,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 > o1 ? 1 : -1;
            }
        });

        System.out.println(Arrays.toString(toSort));
    }
}
