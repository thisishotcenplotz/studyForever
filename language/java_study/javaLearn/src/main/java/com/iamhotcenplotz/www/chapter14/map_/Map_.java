package com.iamhotcenplotz.www.chapter14.map_;

import java.util.HashMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        // Map 与 Collection 并列存在。用于保存具有映射关系的数据 key-value (双列元素)

        HashMap map = new HashMap();

        map.put("a",1);
        map.put("b",2);
        map.put("张无忌","九阳神功");
        map.put("赵敏","周芷若");

        System.out.println(map);

    }
}
