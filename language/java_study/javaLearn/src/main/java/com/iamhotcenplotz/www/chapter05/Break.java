package com.iamhotcenplotz.www.chapter05;

public class Break {
    public static void exercise01() {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                break;
            } else {
                System.out.println(i);
            }
        }
    }

    public static int exercise02() {
        int cnt = 0;
        int randomNumber = 0;

        do {
            randomNumber = (int) (Math.random() * 5000 + 1);
            cnt++;
        } while (randomNumber != 1024);
        return cnt;
    }

    public static void breakDetail() {
        // how to use label
        label1:
        for (int i = 0; i < 4; i++) {
            label2:
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " " + j);
                if (j == 2) {
                    break label2;
                }
            }
            if (i == 3) {
                break label1;
            }

        }
    }

    public static void exercise03() {
        int cnt = 0;
        for (int i = 0; i < 101; i++) {
            cnt += i;

            if (cnt > 20) {
                System.out.println(i + " " + cnt);
                break;
            } 
        }
    }

    public static void main(String[] args) {
//        exercise01();
//        breakDetail();
        exercise03();
    }

}
