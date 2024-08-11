package com.iamhotcenplotz.www.chapter03;

public class CharDetail {
    // Main Method
    public static void main(String[] args) {
        //1. 字符类型是用单引号括起来的单个字符
        //2. java中还允许使用转义字符来将其后的字变为特殊字符型常量  char c3 = '\n'`
        //3. 在java中，char的本质是一个整数，在输出时，是unicode码对应的字符。
        //4. 可以直接给char赋一个整数，然后输出时，会按照对用的unicode字符输出。
        //5. char类型是可以进行运算的，相当于一个整数，因为它都对应有Unicode码。
        char c1 = 97;
        System.out.println(c1); // output --> a;

        System.out.println((int) c1); // output ---> 97;

        // test
        char c2 = 'b' + 10;
        System.out.println((int)c2);
    }
}
