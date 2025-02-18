package com.iamhotcenplotz.chapter05;

import java.util.Scanner;

public class If01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input your age: ");
        int age = scanner.nextInt();

        if (age > 18){
            System.out.println("adult");
        }else {
            System.out.println("child");
        }

    }
}
