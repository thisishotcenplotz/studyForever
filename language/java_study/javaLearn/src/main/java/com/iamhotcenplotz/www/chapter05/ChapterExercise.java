package com.iamhotcenplotz.www.chapter05;

public class ChapterExercise {
    public static void exercise01() {
        double rest = 100000;
        int cnt = 0;

        while (rest >= 1000) {
            if (rest > 50000) {
                rest = rest - (rest * 0.05);
                cnt++;
            } else if (rest <= 50000 && rest > 0) {
                rest -= 1000;
                cnt++;
            }

            if (rest < 1000) {
                break;
            }
        }
        System.out.println(rest);
        System.out.println(cnt);
    }

    public static void exercise02() {
        for (int i = 0; i < 999999999; i++) {
            int sum = 0;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                int curNum = Integer.parseInt(String.valueOf(s.charAt(j)));
                sum += (curNum*curNum*curNum);
            }
            if (sum == i) {
                System.out.println(i);
                System.out.println("~~~~~~~~");
            }


        }
    }

    public static void exercise03() {
        double sum = 1;
        for (int i = 2; i <= 100; i++) {
              if(i % 2 == 0){
                  sum -= (double) (1/(double)(i));
              }else {
                  sum += (double) (1/(double)(i));
              }
        }
        System.out.println(sum);
    }

    public static void exercise04() {
    }

    public static void exercise05() {
    }

    public static void exercise06() {
    }

    public static void exercise07() {
    }

    public static void exercise08() {
    }

    public static void exercise09() {
    }

    public static void main(String[] args) {
//        exercise01();
//        exercise02();
        exercise03();
    }
}
