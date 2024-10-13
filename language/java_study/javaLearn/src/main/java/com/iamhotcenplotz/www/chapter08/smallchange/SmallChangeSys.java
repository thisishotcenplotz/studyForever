package com.iamhotcenplotz.www.chapter08.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        //loop
        boolean loop = true;

        Scanner scanner = new Scanner(System.in);

        String key = "";

        String details = "---------------零钱通明细---------------";

        double money = 0;
        double balance = 0;
        Date date = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String note = "";
        do {
            System.out.println("==============零钱通菜单==============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请选择(1-4):");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();
                    if(money <= 0){
                        System.out.println("收益金额要大于0");
                        break;
                    }

                    balance += money;

                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;

                    break;
                case "3":
                    System.out.print("消费金额:");
                    money = scanner.nextDouble();

                    System.out.print("消费说明:");
                    note = scanner.next();

                    if(money <= 0 || money > balance){
                        System.out.println("你没那么些个钱，别花了...");
                        break;
                    }
                    balance -= money;

                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
                    break;
                case "4":
                    System.out.println("4 退      出");
                    String choice = "";

                    while (true) {
                        System.out.print("确认要退出吗？[y/n]");
                        choice = scanner.next();
                        if ('y' == choice.charAt(0) || 'n' == choice.charAt(0)) {
                            break;
                        }
                    }
                    if (choice.equals('y')) {

                        loop = false;
                    } else if (choice.equals('n')) {
                        break;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);
        System.out.println("-----退出了零钱通-----");
    }
}
