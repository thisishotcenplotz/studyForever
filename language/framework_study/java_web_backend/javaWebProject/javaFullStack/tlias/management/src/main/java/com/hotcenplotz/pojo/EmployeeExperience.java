package com.hotcenplotz.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:06
 * @description:
 */


/**
 *     id int unsigned primary key auto_increment comment 'ID 主键'
 *     ,employee_id int unsigned comment '员工ID'
 *     ,expr_start date comment '开始时间'
 *     ,expr_end date comment '结束时间'
 *     ,expr_company varchar(1024) comment '公司名称'
 *     ,job_title varchar(1024) comment '职位名称'
 */

@Data
public class EmployeeExperience {
    private Integer id;
    private Integer experienceId;
    private LocalDate exprStartDate;
    private LocalDate exprEndDate;
    private String exprCompany;
    private String jobTitle;
    
    
}
