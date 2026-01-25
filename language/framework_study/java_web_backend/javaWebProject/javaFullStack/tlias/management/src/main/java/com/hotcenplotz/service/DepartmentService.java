package com.hotcenplotz.service;

import com.hotcenplotz.pojo.Department;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-24 10:25
 * @description:
 */


public interface DepartmentService {
    
    /**
     * 查询所有的部门数据
     * @return
     */
    List<Department> findAll();
    
    void deleteById(Integer depId);
    
    void add(Department department);
    
    Department getInfo(Integer id);
    
    /**
     * 修改部门
     * @param department
     */
    void update(Department department);
}
