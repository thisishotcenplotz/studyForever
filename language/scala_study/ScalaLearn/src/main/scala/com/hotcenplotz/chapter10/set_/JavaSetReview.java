package com.hotcenplotz.chapter10.set_;

import java.util.HashSet;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-18 09:39
 * @description:
 */


public class JavaSetReview {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("C");
        set.add("D");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
