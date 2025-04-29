package com.iamhotcenplotz.chapter26.restaurant.view;

import com.iamhotcenplotz.chapter26.restaurant.bean.Bill;
import com.iamhotcenplotz.chapter26.restaurant.bean.DiningTable;
import com.iamhotcenplotz.chapter26.restaurant.bean.Employee;
import com.iamhotcenplotz.chapter26.restaurant.bean.Menu;
import com.iamhotcenplotz.chapter26.restaurant.service.BillService;
import com.iamhotcenplotz.chapter26.restaurant.service.DiningTableService;
import com.iamhotcenplotz.chapter26.restaurant.service.EmployeeService;
import com.iamhotcenplotz.chapter26.restaurant.service.MenuService;
import com.iamhotcenplotz.chapter26.restaurant.utils.Utility;

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

    private MenuService menuService = new MenuService();

    private BillService billService = new BillService();

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
                    showMenu();
                    break;
                case "4":
                    order();
                    break;
                case "5":
                    listBill();
                    break;
                case "6":
                    checkout();
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
            System.out.println("+ " + diningTable.getId() + "         ---   " + diningTable.getStatus());
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

        if (confirm == 'Y') {
            DiningTable table = diningTableService.getTable(id);
            if (table == null) {
                System.out.println("餐桌：" + id + " 不存在");
                return;
            }
            if (!"空".equals(table.getStatus())) {
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

    public void showMenu() throws Exception {
        List<Menu> list = menuService.list();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("+ %-6s %-4s %-16s %-12s+\n", "编号", "菜名", "类别", "价格");
        for (Menu menu : list) {
            System.out.printf("+ %-6d [%-4s] %-16s %-12.2f+\n",
                    menu.getId(),
                    menu.getName(),
                    menu.getType(),
                    menu.getPrice());
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public void order() throws Exception {
        System.out.println("+++++++++++++++ 开始点餐 +++++++++++++++");
        System.out.print("请输入点餐的桌号(-1退出):");
        int tableId = Utility.readInt();
        if (tableId == -1) {
            System.out.println("+++++++++++++++ 取消点餐 +++++++++++++++");
            return;
        }
        System.out.print("请输入点餐的菜品号(-1退出):");
        int menuId = Utility.readInt();
        if (menuId == -1) {
            System.out.println("+++++++++++++++ 取消点餐 +++++++++++++++");
            return;
        }
        System.out.print("请输入点餐的数量(-1退出)：");
        int quantity = Utility.readInt();
        if (quantity == -1) {
            System.out.println("+++++++++++++++ 取消点餐 +++++++++++++++");
            return;
        }

        DiningTable table = diningTableService.getTable(tableId);
        if (table == null) {
            System.out.println("餐桌不存在");
            return;
        }

        Menu menu = menuService.get(menuId);
        if (menu == null) {
            System.out.println("菜品不存在");
            return;
        }

        boolean orderStatus = billService.order(menuId, quantity, tableId);
        System.out.println(orderStatus ? "点餐成功" : "点菜失败");
    }

    public void listBill() throws Exception {
        List<Bill> list = billService.list();
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("+ 编号\t\t菜品号\t\t数量\t\t金额\t\t餐桌号\t\t日期\t\t\t\t\t\t\t状态");
        for (Bill bill : list) {
            System.out.println(
                "+ " +bill.getId() +"\t\t\t" +
                bill.getMenu_id() +"\t\t\t" +
                bill.getQuantity() +"\t\t" +
                bill.getUnit_price()+"\t" +
                bill.getTable_id() +"\t\t\t" +
                bill.getBill_date() +"\t\t\t" +
                bill.getPayment_status() +"\t\t"
            );
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
    }

    public void checkout() throws Exception {
        System.out.println("++++++++++ 结账服务 ++++++++++");
        System.out.print("请输入要结账的餐桌编号(-1退出):");
        int tableId = Utility.readInt();

        DiningTable tableStatus = diningTableService.getTable(tableId);
        if (tableStatus == null) {
            System.out.println("结账的餐桌不存在");
            return;
        }

        boolean paidStatus = billService.isPaid(tableId);
        if(paidStatus) {
            System.out.println("没有未结的账单");
            return;
        }

        billService.paid(tableId);
        System.out.println("结账成功");
    }
}

