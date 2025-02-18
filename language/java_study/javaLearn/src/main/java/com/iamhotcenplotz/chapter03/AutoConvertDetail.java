package com.iamhotcenplotz.chapter03;

public class AutoConvertDetail {
    public static void main(String[] args) {
        //1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种类型，然后再进行运算
        int n1 = 10;
        double d1 = n1 + 1.1;
        //2. 当我们把`精度大`的数据类型赋值给`精度小`的数据类型时，就会报错，反之就会进行自动类型转换。
        //3. （byte、short）和char 之间不会自动转换

        //4. byte、short、char它们可以计算，
        //5. boolean不参与转换
        //6. 自动提升原则：表达式结果的类型自动提升为操作数中最大的类型

    }
}
