package com.iamhotcenplotz.chapter12;

import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class BestPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        while (true){
            try {
                System.out.print("请输入一个整数：");
                num = Integer.parseInt(scanner.next());
                break;
            } catch (Exception e){
                System.out.println("输入错误...");
            }
        }

        System.out.println(num);
    }
}
