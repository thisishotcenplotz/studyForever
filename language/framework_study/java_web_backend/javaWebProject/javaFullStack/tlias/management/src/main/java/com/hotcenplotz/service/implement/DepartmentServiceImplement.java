package com.hotcenplotz.service.implement;

import com.hotcenplotz.mapper.DepartmentMapper;
import com.hotcenplotz.pojo.Department;
import com.hotcenplotz.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-24 10:27
 * @description:
 */


@Service
public class DepartmentServiceImplement implements DepartmentService {
    
    @Autowired
    private DepartmentMapper departmentMapper;
    
    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }
    
    @Override
    public void deleteById(Integer depId) {
        departmentMapper.deleteByID(depId);
    }
    
    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }
    
    @Override
    public Department getInfo(Integer id) {
        return departmentMapper.getById(id);
    }
    
    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }
    
}
