package com.iamhotcenplotz.www.chapter14.set_;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SetMethods_ {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();


        // 1. Set 接口的实现类的对象（Set接口对象），不能存放重复的数据
        // 3. null 可以放进去，但是只能放一个
        // 4. 存放的数据是无序的，即添加的顺序和取出的顺序不一致。
        // 5. 注意：取出的顺序是固定的，虽然不是添加的顺序，但是他是固定的。
        hashSet.add("john");
        hashSet.add("jane");
        hashSet.add("jack");
        hashSet.add("joline");
        hashSet.add("joline");

        for (Object o : hashSet) {
            System.out.println(o);
        }

        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
