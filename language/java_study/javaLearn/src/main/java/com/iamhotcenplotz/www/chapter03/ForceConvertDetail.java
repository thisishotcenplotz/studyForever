package com.iamhotcenplotz.www.chapter03;

public class ForceConvertDetail {
    public static void main(String[] args) {
        //强制类型转换细节：
        //1. 当进行数据的大小 从 大 -> 小， 就需要进行强制类型转换
        //2. 强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级。
//        int x = (int)10*3.5_6*1.5;  // 不行
        int y = (int)(10*3.5_6*1.5);
        System.out.println(y); // Ok~
        //3. char类型可以保存int的常量值，但不能保存int的变量值，需要强转
        //4. byte和short类型在进行运算时，当做int类型处理
    }
}
