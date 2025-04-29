package com.iamhotcenplotz.chapter26.restaurant.service;

import com.iamhotcenplotz.chapter26.restaurant.bean.Menu;
import com.iamhotcenplotz.chapter26.restaurant.dao.daos.MenuDAO;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 16:56
 * @description:
 */


public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    public List<Menu> list() throws Exception {
        return menuDAO.queryList(
            "select * from restaurant.menu where 1 = ?"
                ,Menu.class
                ,1
        );
    }
}
