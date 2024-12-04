package com.iamhotcenplotz.www.chapter14.list_;

import java.util.Comparator;
import java.util.Vector;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Vector_ {
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        vector.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 - (Integer) o2;
            }
        });

        for (Object o :vector) {
            System.out.println(o);
        }


    }
}
