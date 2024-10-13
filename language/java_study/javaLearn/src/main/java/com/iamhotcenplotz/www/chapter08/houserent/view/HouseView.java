package com.iamhotcenplotz.www.chapter08.houserent.view;

import com.iamhotcenplotz.www.chapter08.houserent.model.House;
import com.iamhotcenplotz.www.chapter08.houserent.service.HouseService;
import com.iamhotcenplotz.www.chapter08.houserent.utils.Utility;

/**
 * 1. 显示界面
 * 2. 接受用户输入
 * 3. 调用HouseService 完成对房屋信息的各种操作
 */

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    public void listHouses() {
        System.out.println("---------------房屋列表---------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        House[] list = houseService.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                break;
            }
            System.out.println(list[i].toString());
        }
        System.out.println("---------------房屋列表显示完毕---------------");
    }

    public void mainMenu() {
        do {
            System.out.println("---------------房屋出租系统菜单---------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退      出");
            System.out.print("请输入你的选择（1 - 6）");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    System.out.println("查 找");
                    break;
                case '3':
                    System.out.println("删 除");
                    break;
                case '4':
                    System.out.println("修 改");
                    break;
                case '5':
                    System.out.println("房 屋 列 表");
                    break;
                case '6':
                    System.out.println("退出");
                    this.loop = false;
                    break;
            }
        } while (loop);
    }

    public void addHouse(){
        System.out.println("---------------添加房源---------------");

        System.out.print("房主姓名：");
        String name = Utility.readString(8);

        System.out.print("房主电话：");
        String phone = Utility.readString(12);

        System.out.print("房屋地址：");
        String address = Utility.readString(16);

        System.out.print("房屋租金：");
        int rent = Utility.readInt();

        System.out.print("房屋状态：");
        String status = Utility.readString(16);

        House house = new House(0, name, phone, address, rent, status);
        if(houseService.add(house)){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }


    }
}
