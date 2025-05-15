package com.hotcenplotz.chapter10;

import java.util.ArrayList;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-15 07:18
 * @description: Java集合回顾
 * 1. 不可变指的是数组的长度不可变，而数组里边的内容是可以变的。
 */


public class JavaCollectionReview_ {
    public static void main(String[] args) {
        //不可变集合，类似于Java数组
        int[] nums = new int[3];
        nums[0] = 1;
        String[] names = {"a","b"};
        System.out.println(nums + " " + names);

        // 可变集合举例
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        System.out.println(strings + " " + strings.hashCode());
    }
}
