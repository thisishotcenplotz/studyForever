package com.iamhotcenplotz.chapter05;

public class MulFor {
    public static void exercise01() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    public static void exercise02() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    public static void exercise03() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (j <= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void exercise04() {
        int size = 15;

        for (int i = 0; i < size; i++) {
            for (int k = 0; k <= size - i; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void exercise05() {
        int size = 15;

        for (int i = 1; i <= size; i++) {
            for (int k = 1; k <= size - i; k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == size) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void randomNum() {
        int cnt = 0;
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            cnt++;
            System.out.println(cnt + " " + randomNumber);
        } while (randomNumber != 97);

    }

    public static void main(String[] args) {
//        exercise01();
//        exercise02();
//        exercise03();
//        exercise04();
//        exercise05();
        randomNum();
    }
}
