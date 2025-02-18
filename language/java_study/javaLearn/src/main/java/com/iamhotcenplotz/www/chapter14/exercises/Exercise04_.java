package com.iamhotcenplotz.www.chapter14.exercises;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise04_ {
    public static void main(String[] args) {
        // HashSet 和 TreeSet 分别如何实现去重

        /*
        * HashSet: hashCode() + equals(); 底层先通过存入对象，进行运算得到一个
        * hash值，通过hash值得到一个对应的索引，如果发现table 表索引所在，没有数据，就直接存放，
        * 如果有数据或元素就进行equal() 比较【遍历】，如果比较后不相同就加入，否则就不加入。
        *
        * */

        /*
        * TreeSet: 如果传入一个Comparator比较器，就使用实现的compare() 去重，如果方法返回0则相同，反之-2.
        * 如果没有传入Comparator，则以添加的对象实现的Comparable接口的compareTo实现去重。
        * */

        TreeSet treeSet = new TreeSet();

        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // return ...
                return 0;
            }
        });

    }
}
