package com.iamhotcenplotz.chapter05;

public class Continue {
    public static void exercise01() {
        int i = 1;

        while (i <= 4) {
            i++;
            if (i == 2) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void exercise02() {
        label1:
        for (int j = 0; j < 4; j++) {
            label2:
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    continue label1;
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
//        exercise01();
        exercise02();
    }
}
