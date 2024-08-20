package com.iamhotcenplotz.www.chapter05;

public class WhileLoop {
    public static void exercise01(){
        int i = 0;

        while (i <= 100){
            System.out.println(i);
            i++;
        }
    }

    public static void exercise02(){
        int begin = 40;
        int end = 200;
        while (begin <= end){
            if(begin % 3 == 0){
                System.out.println("begin: " + begin);
            }
            begin++;
        }
    }

    public static void main(String[] args) {
        exercise01();
        exercise02();
    }
}
