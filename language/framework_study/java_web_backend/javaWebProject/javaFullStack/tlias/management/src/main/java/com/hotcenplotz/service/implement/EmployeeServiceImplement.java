package com.hotcenplotz.service.implement;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hotcenplotz.controller.DepartmentController;
import com.hotcenplotz.mapper.EmployeeMapper;
import com.hotcenplotz.pojo.Employee;
import com.hotcenplotz.pojo.PageResult;
import com.hotcenplotz.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:11
 * @description:
 */

@Service
public class EmployeeServiceImplement implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImplement.class);
    
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    // ------------------ 原始分页查询 ---------------
//    @Override
//    public PageResult<Employee> page(Integer page, Integer pageSize) {
//
//        // 1. 查询总记录数
//        Long count = employeeMapper.count();
//        System.out.println(count);
//
//        // 2. 查询结果列表
//        Integer _startPage = page >= 1 ? page : 1;
//        Integer start = (_startPage - 1) * pageSize;
//        log.info("start, pageSize: {},{}", start, pageSize);
//        List<Employee> rows = employeeMapper.list(start, pageSize);
//
//        return new PageResult<Employee>(count, rows);
//    }
    
    
    @Override
    public PageResult<Employee> page(
        Integer page,
        Integer pageSize,
        String name,
        Integer gender,
        LocalDate begin,
        LocalDate end
    ) {
        
        // 1. 查询总记录数
        Long count = employeeMapper.count();
        System.out.println(count);
        
        // 2. 查询结果列表
        Integer _startPage = page >= 1 ? page : 1;
        Integer start = (_startPage - 1) * pageSize;
        log.info("start, pageSize: {},{}", start, pageSize);
        List<Employee> rows = employeeMapper.list(start, pageSize,name,gender,begin,end);
        
        return new PageResult<Employee>(count, rows);
    }
    
    // ------------------------ PageHelper 分页查询 -------------------
//    @Override
//    public PageResult<Employee> page(Integer page, Integer pageSize) {
//
//        // 1. 设置分页参数
//        PageHelper.startPage(page, pageSize);
//
//        // 2. 执行查询
//        List<Employee> list = employeeMapper.list();
//
//        // 3. 查询结果
//        Page<Employee> p = (Page<Employee>) list;
//
//        return new PageResult<Employee>(p.getTotal(), p.getResult());
//    }
}
