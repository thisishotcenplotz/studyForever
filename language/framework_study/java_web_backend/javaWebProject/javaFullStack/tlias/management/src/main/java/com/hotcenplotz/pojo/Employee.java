package com.hotcenplotz.pojo;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 19:57
 * @description:
 */


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * id int unsigned primary key auto_increment comment 'ID，主键'
 * ,username varchar(20) not null unique comment '用户名'
 * ,password varchar(30) not null comment '密码'
 * ,name varchar(10) not null comment '姓名'
 * ,gender tinyint unsigned not null comment '性别 1：男，2：女'
 * ,phone char(11) not null unique comment '手机号'
 * ,job tinyint unsigned comment '职位，1：xxx, 2:ooo'
 * ,salary decimal(15,2) unsigned comment '薪资'
 * ,image varchar(255) comment '头像'
 * ,entry_date date comment '入职时间'
 * ,created_at datetime comment '创建时间'
 * ,updated_at datetime comment '修改时间'
 * ,department_id int unsigned comment '关联的部门ID'
 */

@Data
public class Employee {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer job;
    private BigDecimal salary;
    private String image;
    private LocalDate entryDate;      // 注意：数据库列是 entry_date
    private LocalDateTime createdAt;  // 注意：数据库列是 created_at
    private LocalDateTime updatedAt;  // 注意：数据库列是 updated_at
    private Integer departmentId;     // 注意：数据库列是 department_id
    private String departmentName;    // 查询结果中的别名
    
    public Employee() {
    }
    
    public Employee(Integer id, String username, String password, String name, Integer gender, String phone, Integer job, BigDecimal salary, String image, LocalDate entryDate, LocalDateTime createdAt, LocalDateTime updatedAt, Integer departmentId, String departmentName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.job = job;
        this.salary = salary;
        this.image = image;
        this.entryDate = entryDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getGender() {
        return gender;
    }
    
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Integer getJob() {
        return job;
    }
    
    public void setJob(Integer job) {
        this.job = job;
    }
    
    public BigDecimal getSalary() {
        return salary;
    }
    
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public LocalDate getEntryDate() {
        return entryDate;
    }
    
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public Integer getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
