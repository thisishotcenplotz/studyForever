package com.iamhotcenplotz.www.chapter14;

import java.util.Hashtable;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class HashTableExercise_ {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();

        table.put("john","100");
        table.put("rick","90");
        table.put("hardy","95");

        // throw NullPointerException.
//        table.put(null,100);

        // replace
        table.put("rick","80");

        System.out.println(table);
    }
}
