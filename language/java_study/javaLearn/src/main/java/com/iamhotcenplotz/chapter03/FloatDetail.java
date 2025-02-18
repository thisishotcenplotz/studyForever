package com.iamhotcenplotz.chapter03;

public class FloatDetail {
    public static void main(String[] args) {
        //java的浮点型常量默认为double，声明float需要加后缀`f`
        float num1 = 1.1f;

        double num2 = 1.1;

        double num3 = 1.1f; // OK~


        // - 浮点型有两种表示方式
        // - 十进制：5.12 ，512.0f，.512
        double num5 = .512;

        // - 科学计数法: 5.12e2[] 5.12E-2 []
        double num6 = 5.12e2;
        double num7 = 5.12e-2;

        //当对运算结果是小数的进行相等判断要小心
        double num8 = 8.1 / 3;
        System.out.println(num8);

        if (num8 == 2.7) {
            System.out.println("equal~");
        } else {
            System.out.println("not equal~");
        }
        // 应该是以两个数的差值的绝对值，在某个精度范围内来判断
        if (Math.abs(num8 - 2.7) <= 0.0001) {
            System.out.println("equal");
        }

    }
}
