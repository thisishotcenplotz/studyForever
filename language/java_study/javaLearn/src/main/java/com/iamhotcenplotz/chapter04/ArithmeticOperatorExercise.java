package com.iamhotcenplotz.chapter04;

public class ArithmeticOperatorExercise {
    public static void exercise01() {
        int i = 1;
        i = i++;
        System.out.println(i); // 1
    }

    public static void exercise02() {
        int i = 1;
        i = ++i;
        System.out.println(i); // 2
    }

    public static void exercise03() {
        int i1 = 10;
        int i2 = 20;
        int i = i1++;
        System.out.println(i);  // 10
        System.out.println(i2); // 20
        i = --i2;
        System.out.println(i);
        System.out.println(i2);
    }

    public static void exercise04() {
        // 1. 加入还有59天放假，问： 合XX个星期零几天
        int toBreak = 59;
        int toBreakDay = toBreak % 7;
        int toBreakWeek = (toBreak - toBreakDay) / 7;
        System.out.println("weeks: " + toBreakWeek + "; day: " + toBreakDay);

        // 2. 定义一个变量保存华氏度，华氏度转摄氏度公式：5/9*(华氏度-100)，华氏度对摄氏度温度（234.5）
        double FTemperature = 234.5;
        double CTemperature = 5.0 / 9 * (FTemperature - 100);
        System.out.println(CTemperature);
    }

    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();
    }

}
