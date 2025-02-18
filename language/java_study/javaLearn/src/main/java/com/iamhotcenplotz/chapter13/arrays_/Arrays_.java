package com.iamhotcenplotz.chapter13.arrays_;

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

        // binary sort
        Arrays.sort(toSort);

        Arrays.sort(toSort,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 > o1 ? 1 : -1;
            }
        });

        System.out.println(Arrays.toString(toSort));
        Integer[] integers = Arrays.copyOf(toSort, toSort.length);
        Integer[] integers2 = Arrays.copyOf(toSort, toSort.length + 1);

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(integers2));

        int[] a = {1,2,3};
        // 用指定的数字，替换列表中的所有元素
        Arrays.fill(a,123);

        System.out.println(Arrays.toString(a));
    }
}
