package com.iamhotcenplotz.www.chapter05;

import java.util.Scanner;

public class DoWhile {
    public static void exercise01() {
        int i = 0;

        do {
            System.out.println(i);
            i++;
        } while (i <= 100);
    }

    public static void exercise02() {
        int i = 1;

        do {
            if (i % 5 == 0) {
                System.out.println(i);
            }
            i++;
        } while (i <= 200);
    }

    public static void exercise03() {
        Scanner scanner = new Scanner(System.in);
        char ans;
        do {
            System.out.println("闪电五连鞭~~~");
            System.out.println("还钱吗？【y/n】");
            ans = scanner.next().charAt(0);

        } while (ans != 'y');
    }

    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
    }
}
