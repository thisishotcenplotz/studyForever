package com.iamhotcenplotz.chapter05;

public class ForExercise {
    public static void exercise01(){
        int sum = 0;
        int cnt = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 9 == 0){
                System.out.println(i);
                sum += i;
                cnt += 1;
            }
        }

        System.out.println(sum);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        exercise01();
    }
}
