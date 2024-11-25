package com.iamhotcenplotz.www.chapter13.wrapper_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class WrapperExercise01 {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(1);
        Integer j = Integer.valueOf(1);

        System.out.println(i == j);

        Integer m = 1;
        Integer n = 1;

        System.out.println(m == 1);

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false; check source code.

        // 如果有基本数据类型，则==判断的是值是否相等。
    }
}
