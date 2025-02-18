package com.iamhotcenplotz.chapter05;
import java.util.Scanner;
public class If03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter Baoguo's score");

        // 保国的芝麻信用分
        int score = scanner.nextInt();

        if( score == 100 ){
            System.out.println("very good");
        } else if (score > 80 && score <= 99) {
            System.out.println("good");
        } else if (score >= 80 && score <= 80) {
            System.out.println("ok");
        } else {
            System.out.println("bad");
        }
    }
}
