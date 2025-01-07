package com.iamhotcenplotz.www.chapter14.map_;

import java.util.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class MapIteration_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("邓超", new Book("aaa", "bbb"));
        hashMap.put("邓超", "孙俪");
        hashMap.put("王宝强", "马蓉");
        hashMap.put("宋喆", "马蓉");
        hashMap.put("鹿晗", "关晓彤");

        // 1. 增强for
        for(Object key : hashMap.keySet()) {
            System.out.println(key + ":" + hashMap.get(key));
        }

        // 2. iterator
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + ":" + hashMap.get(key));
        }

        // 3. all values
        Collection values = hashMap.values();
        for(Object value : values) {
            System.out.println(value);
        }

        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        // 4. EntrySet
        Set set = hashMap.entrySet();
        for(Object entry : set) {
            // convert entry to Map.Entry
            Map.Entry entry1 = (Map.Entry) entry;

            System.out.println(entry1.getKey() + ":" + entry1.getValue());
        }

    }
}
