package com.iamhotcenplotz.chapter05;

import java.util.Scanner;

public class If02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input your age: ");
        int age = scanner.nextInt();

        if (age > 20){
            System.out.println("adult");
        }else {
            System.out.println("child");
        }

    }
}
