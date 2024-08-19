package com.iamhotcenplotz.www.chapter05;

import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("score: ");
        double score = scanner.nextDouble();

        if (score >= 8.0){
            System.out.println("in");
            System.out.println("gender: ");

            char gender = scanner.next().charAt(0);

            if (gender == 'M'){
                System.out.println("M");
            } else if (gender == 'F') {
                System.out.println("F");
            }
        }else {
            System.out.println("out");
        }

    }
}
