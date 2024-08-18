package com.iamhotcenplotz.www.chapter05;

public class IfExercise {
    public static void segment(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public static void exercise01(){
        double d1 = 34.5;
        double d2 = 2.6;

        if(d1 > 10.0 && d2< 20.0){
            System.out.println(d1 + d2);
        }
    }

    public static void exercise02(){
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;

        if( sum % 3 == 0 && sum % 5 == 0){
            System.out.println("good");
        }else {
            System.out.println("bad");
        }

    }

    public static void exercise03(){
        int yr = 2024;

        // 是不是闰年
        if((yr % 4 == 0 && yr % 100 != 0) || (yr % 400 == 0)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
    public static void main(String[] args) {
        exercise01();
        segment();
        exercise02();
        segment();
        exercise03();
        segment();
    }
}
