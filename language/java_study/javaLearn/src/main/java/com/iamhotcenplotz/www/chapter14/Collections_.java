package com.iamhotcenplotz.www.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        // max
        System.out.println(Collections.max(list));

        System.out.println(Collections.max(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1.toString().length() > o2.toString().length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }));

        // min
        System.out.println(Collections.min(list));

        // frequency
        System.out.println(Collections.frequency(list, "a"));

        // replace
        Collections.replaceAll(list, "a", "aa");
        System.out.println(list);

        // copy
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add("");
        }
        Collections.copy(arrayList, list);
        System.out.println(arrayList);
    }
}
