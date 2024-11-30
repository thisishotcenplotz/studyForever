package com.iamhotcenplotz.www.chapter13.string_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class StringBuffer_ {
    /*
    StringBuffer 代表可变的字符序列，可以对字符串内容进行增删改，
    且长度是可变的；
    它是一个容器

    效率高于String
    */
    public static void main(String[] args) {

        // 默认容器长度 16
        StringBuffer one = new StringBuffer();

        // 初始容器长度为100
        StringBuffer two = new StringBuffer(100);

        // 直接给一个String，容器长度为："Hello World".length() + 16
        StringBuffer three = new StringBuffer("Hello World");

        // String 与 StringBuffer 之间的相互转换

        // String -> StringBuffer
        String str = "Hello Spark";
        StringBuffer methodOne = new StringBuffer(str); // 使用构造器
        StringBuffer methodTwo = new StringBuffer().append(str); // append

        // StringBuffer -> String

        StringBuffer b = new StringBuffer("Hello Flink");
        String strMethodOne = b.toString();
        String strMethodTwo = new String(b);

        // 千分位输出
        String price = "11212121223456789.321";
        StringBuffer bufferPrice = new StringBuffer(price);

        for (int i = bufferPrice.lastIndexOf(".") - 3; i > 0; i-=3) {
            bufferPrice.insert(i,",");
        }

        System.out.println(bufferPrice);





    }
}
