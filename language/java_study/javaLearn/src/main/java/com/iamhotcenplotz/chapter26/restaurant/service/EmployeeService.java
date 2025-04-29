package com.iamhotcenplotz.chapter26.restaurant.service;

import com.iamhotcenplotz.chapter26.restaurant.bean.Employee;
import com.iamhotcenplotz.chapter26.restaurant.dao.daos.EmployeeDAO;

import java.sql.SQLException;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 14:40
 * @description: 对restaurant.employee 的各种操作，通过调用EmployeeDAO
 */


public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();

    // 根据emp_id 和 pwd 返回 一个对象
    public Employee getEmployeeByIdAndPwd(String emp_id,String pwd) throws SQLException {
        return dao.query(
                "select * from restaurant.employee where emp_id = ? and pwd = md5(?)"
                ,Employee.class
                ,emp_id,pwd
        );
    }
}
