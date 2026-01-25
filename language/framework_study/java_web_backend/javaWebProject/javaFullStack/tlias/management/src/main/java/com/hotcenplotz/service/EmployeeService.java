package com.hotcenplotz.service;

import com.hotcenplotz.pojo.Employee;
import com.hotcenplotz.pojo.PageResult;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:11
 * @description:
 */



public interface EmployeeService {
    
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页展示的记录数
     * @return
     */
    // PageResult<Employee> page(Integer page, Integer pageSize);
    
    PageResult<Employee> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}
