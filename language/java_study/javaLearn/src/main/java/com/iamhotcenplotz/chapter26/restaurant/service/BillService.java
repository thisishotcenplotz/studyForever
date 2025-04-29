package com.iamhotcenplotz.chapter26.restaurant.service;

import com.iamhotcenplotz.chapter26.restaurant.bean.Bill;
import com.iamhotcenplotz.chapter26.restaurant.bean.Menu;
import com.iamhotcenplotz.chapter26.restaurant.dao.daos.BillDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 17:24
 * @description:
 */


public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();

    public boolean order(int menuID, int quantity, int tableId) throws Exception {
        // 生成账单ID
        String billId = UUID.randomUUID().toString().replace("-", "");

        Menu menu = menuService.get(menuID);
        BigDecimal unitPrice = menu.getPrice().multiply(new BigDecimal(quantity));

        boolean tableStatus = diningTableService.updateTableStatus(tableId, "就餐中");

        // bill data persist
        int updateStatus = billDAO.update(
                "insert into restaurant.bill " +
                        "(bill_id,menu_id,quantity,table_id,bill_date,payment_status,unit_price) " +
                        "values " +
                        "(?,?,?,?,now(),?,?) "
                , billId, menuID, quantity, tableId, "未结账", unitPrice
        );

        System.out.println(updateStatus > 0 && tableStatus ? "更新成功" : "更新失败");
        return updateStatus > 0 && tableStatus;

    }

    public List<Bill> list() throws Exception {
        return billDAO.queryList(
                "select * from restaurant.bill where 1 = ?"
                , Bill.class
                , 1
        );
    }

    //查看某张桌子是否有未结账的账单
    public boolean isPaid(int tableId) throws Exception {
        List<Bill> bills = billDAO.queryList(
                "select * from restaurant.bill where payment_status = '未结账' and table_id = ? limit 1"
                , Bill.class
                , tableId
        );
        return bills.isEmpty();
    }

    public boolean paid(int tableId) throws Exception {
        // 修改 bill
        int billStatus = billDAO.update(
            "update restaurant.bill set payment_status = '已支付' where table_id = ? and payment_status = '未结账'"
            , tableId
        );

        if(billStatus != 0){
            // 修改 table
            boolean tableStatus = diningTableService.updateTableStatus(tableId, "空");

            if(tableStatus){
                return diningTableService.resetTable(tableId);
            }
            return false;
        }
        return false;
    }
}
