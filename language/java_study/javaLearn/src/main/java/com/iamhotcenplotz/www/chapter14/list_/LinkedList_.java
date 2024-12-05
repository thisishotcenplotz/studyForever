package com.iamhotcenplotz.www.chapter14.list_;

import java.util.LinkedList;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.remove();
        System.out.println(linkedList);
    }
}
