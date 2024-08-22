package com.iamhotcenplotz.www.chapter05;

public class Return {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println("~~~~");
                return;
            }
            System.out.println("!!!!!");
        }
        System.out.println("u never see me ...");
    }
}
