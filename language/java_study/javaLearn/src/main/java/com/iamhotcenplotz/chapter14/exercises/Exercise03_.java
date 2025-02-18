package com.iamhotcenplotz.chapter14.exercises;

import java.util.HashMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise03_ {
    public static void main(String[] args) {
        HashMap<String, Integer> salary = new HashMap<>();

        salary.put("jack",650);
        salary.put("tom",1200);
        salary.put("jane",1500);
        salary.put("George",30000);

        System.out.println(salary);

        salary.put("jack",2600);
        System.out.println(salary);

        salary.replaceAll((k, v) -> salary.get(k) + 100);

        for (String key: salary.keySet()){
            System.out.println(key + ": " + salary.get(key));
        }
    }
}
