package com.iamhotcenplotz.chapter14.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {

        // 1. 当使用无参构造器创建TreeSet时，仍然是无序的。
        // 2. 如果希望按照添加元素的字符来排序时
        // 3. 使用TreeSet 提供的构造器，可以传入一个比较器 Comparator（匿名内部类），指定排序规则

        TreeSet treeSet = new TreeSet(
            new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    // 调用String compareTo 进行字符串ascii大小比较
                    return ((String) o1).compareTo((String) o2);
                }
            }
        );

        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("a");
        treeSet.add("b");

        System.out.println(treeSet);

    }
}
