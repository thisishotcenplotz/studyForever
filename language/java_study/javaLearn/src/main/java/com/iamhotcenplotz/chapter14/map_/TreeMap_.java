package com.iamhotcenplotz.chapter14.map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(
            new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
//                    return o1.toString().compareTo(o2.toString());
                    if(o1.toString().length() > o2.toString().length()) {
                        return 1;
                    }else {
                        return -1;
                    }

                }
            }
        );

        treeMap.put("A",1);
        treeMap.put("B",1);
        treeMap.put("C",1);
        treeMap.put("D",1);
        treeMap.put("AA",1);
        treeMap.put("BB",1);

        System.out.println(treeMap);
    }
}
