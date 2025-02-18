package com.iamhotcenplotz.chapter14.list_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ListMethods_ {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("Jack");
        arrayList.add("Monet");
        arrayList.add("Nicole");
        arrayList.add("Vast");
        arrayList.add("Jayant");
        arrayList.add("Zoey");
        arrayList.add("Carol");
        arrayList.add("Billy");
        arrayList.add("Ashly");

        // list支持索引

        Object o = arrayList.get(3);

        //
        arrayList.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

//        for (Object obj : arrayList){
//            System.out.println(obj);
//        }


        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toCharArray()[0] - o2.toCharArray()[0];
            }
        });


        for (Object obj : arrayList){
            System.out.println(obj);
        }

    }
}
