package com.iamhotcenplotz.www.chapter05;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class SwitchExample {

    public static void switchExample01(){
        Scanner scanner = new Scanner(System.in);

        char command = scanner.next().charAt(0);

        switch (command){
            case 'a':
                System.out.println("Monday");
                break;
            case 'b':
                System.out.println("Tuesday");
                break;
            case 'c':
                System.out.println("Wednesday");
                break;
            case 'd':
                System.out.println("Thursday");
                break;
            case 'e':
                System.out.println("Friday");
                break;
            case 'f':
                System.out.println("Saturday");
                break;
            case'g':
                System.out.println("Sunday");
                break;
            default:
                System.out.println("error");
                break;
        }

    }
    public static void switchExercise01(){
        char demo = 'a';

        switch (demo){
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            default:
                System.out.println("ok...");
                break;
        }
    }

    public static void switchExercise02(){
        double score = 88.5;
        switch ((int) (score / 60)){
            case 0:
                System.out.println("bad");
                break;
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
    public static void exercise03(){
        Scanner scanner = new Scanner(System.in);
        int month = 1;

        switch (month){
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("fall");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("winter");
                break;
            default:
                System.out.println("error...");
                break;
        }
    }
    public static void main(String[] args) {

    }



}
