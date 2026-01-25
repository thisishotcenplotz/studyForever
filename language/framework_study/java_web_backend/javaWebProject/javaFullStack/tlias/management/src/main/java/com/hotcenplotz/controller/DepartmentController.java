package com.hotcenplotz.controller;

import com.hotcenplotz.pojo.Department;
import com.hotcenplotz.pojo.Result;
import com.hotcenplotz.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-24 11:10
 * @description:
 */

@RestController
@RequestMapping("/depts")
public class DepartmentController {
    
//     使用Logback 管理日志信息
    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;
    
    
    @GetMapping
    public Result list() {
        log.info("=== 开始查询部门数据 ===");
        
        // 1. 调用 Service
        List<Department> departmentList = departmentService.findAll();
        
        // 2. 创建返回结果
        Result result = Result.success(departmentList);
        System.out.println("返回的 Result: " + result);
        
        return result;
    }
    
    /**
     * 删除部门
     *
     * 注意事项： 一旦声明了@RequestParam  就必须传 不然报错
     * 因为 这里有个     boolean required() default true;
     */
    @DeleteMapping
    public Result delete(@RequestParam("id") Integer depId) {
        log.info("===> 接收到的需删除的部门ID：{}", depId);
        departmentService.deleteById(depId);
        return Result.success(depId);
    }
    
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        Integer depId = Integer.parseInt(request.getParameter("id"));
//        System.out.println("===> 接收到的需删除的部门ID：" + depId);
//
//        return Result.success(depId);
//    }
    
    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Department department) {
        log.info("===> 接收到新的部门名称：{}", department.getName());
        departmentService.add(department);
        return Result.success();
    }
    
    /**
     * 根据ID查询部门
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("===> 接收到需要查询的部门ID：{}", id);
        Department department = departmentService.getInfo(id);
        return Result.success(department);
    }
    
    /**
     * 根据ID修改部门的名字
     */
    @PutMapping
    public Result update(@RequestBody Department department) {
        log.info("===> 接收需要修改的部门ID：{}", department.getId());
        log.info("===> 接收需要修改的部门name：{}", department.getName());
        
        departmentService.update(department);
        return Result.success();
    }
}
