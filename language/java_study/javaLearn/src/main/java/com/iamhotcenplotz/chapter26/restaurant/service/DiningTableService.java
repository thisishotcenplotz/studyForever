package com.iamhotcenplotz.chapter26.restaurant.service;

import com.iamhotcenplotz.chapter26.restaurant.bean.DiningTable;
import com.iamhotcenplotz.chapter26.restaurant.dao.daos.DiningTableDAO;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 15:50
 * @description:
 */


public class DiningTableService {
    //DiningTable
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    // 返回所有餐桌信息
    public List<DiningTable> list() throws Exception {
        return diningTableDAO.queryList(
            "select * from restaurant.dining_table where 1 = ?"
            ,DiningTable.class,1
        );
    }

    // 根据ID查询对应的餐桌
    public DiningTable getTable(Integer id) throws SQLException {
        return diningTableDAO.query(
            "select * from restaurant.dining_table where id = ?"
                ,DiningTable.class
                ,id
        );
    }

    public boolean reserveTable(Integer id,String name,String phone) throws Exception {
        int result = diningTableDAO.update(
            "update restaurant.dining_table set status = ? , order_name = ? , order_tel = ? where id = ?"
            , "已预定", name, phone, id
        );
        return result > 0;
    }

}
