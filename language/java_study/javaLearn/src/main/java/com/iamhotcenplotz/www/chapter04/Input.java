package com.iamhotcenplotz.www.chapter04;
import java.util.Scanner;
public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input your name: ");
        String name = scanner.next();
        System.out.println("input your age： ");
        int age = scanner.nextInt();
        System.out.println("input your score: ");
        double score = scanner.nextDouble();
        System.out.println(name);
        System.out.println(age);
        System.out.println(score);
    }
}
