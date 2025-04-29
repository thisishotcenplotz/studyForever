package com.iamhotcenplotz.chapter26.restaurant.view;

import com.iamhotcenplotz.chapter26.restaurant.bean.DiningTable;
import com.iamhotcenplotz.chapter26.restaurant.bean.Employee;
import com.iamhotcenplotz.chapter26.restaurant.service.DiningTableService;
import com.iamhotcenplotz.chapter26.restaurant.service.EmployeeService;
import com.iamhotcenplotz.chapter26.restaurant.utils.Utility;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 13:51
 * @description: 满汉楼View
 */


public class View {
    // 用于控制是否循环打印
    private boolean loop = true;

    // 接收用户的选项
    private String key = "";

    // EmployeeService
    private EmployeeService empService = new EmployeeService();

    // Dining Table Service
    private DiningTableService diningTableService = new DiningTableService();

    // 显示主菜单
    public void mainMenu() throws Exception {
        String menu = "===============" + " 满汉楼 " + "===============" + "\n" +
                "           1.登录满汉楼" + "\n" +
                "           2.退出满汉楼" + "\n";

        while (loop) {
            System.out.println(menu);
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    System.out.print("请输入员 工 号: ");
                    String id = Utility.readString(50);
                    System.out.print("请输入员工密码: ");
                    String pwd = Utility.readString(50);

                    Employee employee = empService.getEmployeeByIdAndPwd(id, pwd);
                    // 验证数据
                    if (employee != null) {
                        System.out.println("=============== 登录成功" + "[" + employee.getName() + "] ===============");
                        // 显示二级菜单
                        showSubMenu();
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.print("输入有误，请重新输入:");
            }
        }

        System.out.println("欢迎再次光临");
    }

    public void showSubMenu() throws Exception {
        String menu = "===============" + " 满汉楼二级菜单 " + "===============" + "\n" +
                "             1.显示餐桌状态" + "\n" +
                "             2.预 定 餐 桌" + "\n" +
                "             3.显示所有菜品" + "\n" +
                "             4.点 餐 服 务" + "\n" +
                "             5.查 看 账 单" + "\n" +
                "             6.结      账" + "\n" +
                "             9.退      出" + "\n";

        while (loop) {
            System.out.println(menu);
            System.out.print("请输入你的选择:");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    showTableStatus();
                    break;
                case "2":
                    reservation();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.print("输入有误，请重新输入:");
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new View().mainMenu();
    }

    private void showTableStatus() throws Exception {
        List<DiningTable> list = diningTableService.list();
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("+ [餐桌编号] --- [餐桌状态]");
        for (DiningTable diningTable : list) {
            System.out.println("+ "+ diningTable.getId() + "         ---   " + diningTable.getStatus());
        }
        System.out.println("+++++++++++++++++++++++++++++++");
    }

    private void reservation() throws Exception {
        System.out.print("请输入桌子编号(-1 退出)：");
        int id = Utility.readInt();

        if (id == -1) {
            System.out.println("取消预定");
            return;
        }

        char confirm = Utility.readConfirmSelection();

        if(confirm == 'Y'){
            DiningTable table = diningTableService.getTable(id);
            if (table == null) {
                System.out.println("餐桌：" + id + " 不存在");
                return;
            }
            if(!"空".equals(table.getStatus())){
                System.out.println("餐桌忙~ 预定失败");
                return;
            }

            System.out.print("请输入预定人姓名: ");
            String n = Utility.readString(50);
            System.out.print("请输入预定人电话：");
            String p = Utility.readString(50);

            boolean status = diningTableService.reserveTable(id, n, p);

            System.out.println(status ? "预定成功" : "预定失败");
        } else {
            return;
        }




    }

}
