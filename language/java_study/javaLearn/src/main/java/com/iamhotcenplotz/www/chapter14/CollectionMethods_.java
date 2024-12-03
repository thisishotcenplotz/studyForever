package com.iamhotcenplotz.www.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class CollectionMethods_ {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("A");
        list.add(10);
        list.add(true);

        System.out.println(list);

        // remove
        list.remove(0);
        System.out.println(list);

        // contains
        System.out.println(list.contains(10));

        // size
        System.out.println(list.size());

        // is empty
        System.out.println(list.isEmpty());

        // clear
        list.clear();

        ArrayList list2 = new ArrayList();
        list2.add("hong lou meng");
        list2.add("san guo yan yi");

        list.addAll(list2);

        System.out.println(list);
    }
}
