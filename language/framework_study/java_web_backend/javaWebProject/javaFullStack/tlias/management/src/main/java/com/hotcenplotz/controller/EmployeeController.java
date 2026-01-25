package com.hotcenplotz.controller;

import com.hotcenplotz.pojo.Employee;
import com.hotcenplotz.pojo.PageResult;
import com.hotcenplotz.pojo.Result;
import com.hotcenplotz.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:13
 * @description:
 */


@RestController
@RequestMapping("/emps")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;
    
    /**
     * 分页查询
     */
//    @GetMapping
//    public Result page(
//        @RequestParam(defaultValue = "1") Integer page,
//        @RequestParam(defaultValue = "10") Integer pageSize
//    ){
//        log.info("分页查询： {},{}",page,pageSize);
//        PageResult<Employee> result =  employeeService.page(page,pageSize);
//        return Result.success(result);
//    }
//
    /**
     * 条件分页查询
     */
    @GetMapping
    public Result page(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize,
        String name,
        Integer gender,
        @RequestParam(defaultValue = "1900-01-01") @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd") LocalDate begin,
        @RequestParam(defaultValue = "9999-12-31") @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd") LocalDate end
    ){
        log.info("分页查询： {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageResult<Employee> result =  employeeService.page(page,pageSize,name,gender,begin,end);
        return Result.success(result);
    }
    
}
