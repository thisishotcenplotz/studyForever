package com.hotcenplotz.chapter10.map_;

import java.util.HashMap;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-05-18 09:02
 * @description:
 */


public class JavaReview_ {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("NO1", 100);
        map.put("NO2", 200);
        map.put("NO3", 300);

        System.out.println(map); // 无序的
        System.out.println(map.get("NO1"));
    }
}
