package com.iamhotcenplotz.chapter02;

public class ChangeChar {
    public static void Exercise() {
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("书名\t作者\t价格\t销量\n三国\t罗贯中\t120\t1000");
        System.out.println("+++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        // 制表位
        System.out.println("北京\t天津\t上海\t");
        // 换行符
        System.out.println("Jack\nSmith\nMarry");
        // 一个\
        System.out.println("Hello\\Ohio");
        System.out.println("Hello\\\\Ohio");
        // 一个"
        System.out.println("老韩说:\"要好好学习,有前途\"");
        // 一个'
        System.out.println("老韩说:\'要好好学习,有前途\'");
        // 一个回车
        System.out.println("DerHotcenplotz\rShenzhen"); // output: Shenzhen
        System.out.println("DerHotcenplotz\r\nShenzhen");

        Exercise();


    }

}

