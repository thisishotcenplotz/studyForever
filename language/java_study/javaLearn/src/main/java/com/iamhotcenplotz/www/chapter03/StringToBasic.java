package com.iamhotcenplotz.www.chapter03;

public class StringToBasic {
    public static void main(String[] args) {
        // 基本数据类型转String
        int n1 = 100;
        float f1 = 1.1f;
        double d1 = 4.5;
        boolean b1 = true;

        String s1 = n1 + "";
        String s2 = f1 + "";
        String s3 = d1 + "";
        String s4 = b1 + "";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        // String -> 基本数据类型
        int i = Integer.parseInt(s1);
        float v = Float.parseFloat(s2);
        double v1 = Double.parseDouble(s3);
        boolean b = Boolean.parseBoolean(s4);

        // 将String转char
        System.out.println("124".charAt(0));
    }
}
