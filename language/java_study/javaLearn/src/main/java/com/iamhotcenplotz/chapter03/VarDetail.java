package com.iamhotcenplotz.chapter03;

public class VarDetail {
    public static void main(String[] args) {
         // 变量必须先声明再使用
        int a = 50;
        System.out.println(a);
        //该区域的数据可以在同一类型范围内不断变化
        a = 88;
        System.out.println(a);

        // 变量在同一个作用域不能重名
        // int a = 77;  // 这样不行。
    }
}
