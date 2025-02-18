package com.iamhotcenplotz.chapter09.houserent.view;

import com.iamhotcenplotz.chapter09.houserent.model.House;
import com.iamhotcenplotz.chapter09.houserent.service.HouseService;
import com.iamhotcenplotz.chapter09.houserent.utils.Utility;

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
                    find();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }

    public void deleteHouse() {
        System.out.println("---------------删除房源---------------");
        System.out.println("---------请输入待删除房屋的编号---------");
        int delID = Utility.readInt();
        if (delID == -1) {
            System.out.println("放弃删除");
            return;
        }
        char choice = Utility.readConfirmSelection();

        if (choice == 'Y') {
            if (houseService.del(delID)) {
                System.out.println("删除成功");
            } else {
                System.out.println("编号不存在，删除失败");
            }
        } else {
            System.out.println("放弃删除");
        }
    }

    public void addHouse() {
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
        if (houseService.add(house)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void find() {
        System.out.println("请输入要查找的ID: ");
        int findID = Utility.readInt();
        House house = houseService.findById(findID);

        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("房屋不存在");
        }
    }

    public void update() {
        System.out.println("修改房屋信息");
        System.out.print("请选择待修改房屋的编号:");

        int updateId = Utility.readInt();

        if(updateId == -1){
            System.out.println("放弃修改...");
            return;
        }

        House house = houseService.findById(updateId);

        if (house == null) {
            System.out.println("编号：" + updateId + " 不存在");
            return;
        }

        System.out.println(house.getName());
        String name = Utility.readString(8);
        if(!"".equals(name)){
            house.setName(name);
        }

        System.out.println(house.getPhone());
        String  phone = Utility.readString(12);
        if(!"".equals(phone)){
            house.setPhone(String.valueOf(phone));
        }

        System.out.println(house.getAddress());
        String  addr = Utility.readString(18);
        if(!"".equals(addr)){
            house.setAddress(String.valueOf(addr));
        }

        System.out.println(house.getRent());
        int  rent = Utility.readInt(-1);
        if(rent != -1){
            house.setRent(rent);
        }

        System.out.println(house.getStatus());
        String   status = Utility.readString(20);
        if(!"".equals(status)){
            house.setStatus(status);
        }

        System.out.println("修改成功");

    }


}
