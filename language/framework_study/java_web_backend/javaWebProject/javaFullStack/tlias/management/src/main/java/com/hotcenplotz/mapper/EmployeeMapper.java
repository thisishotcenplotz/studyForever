package com.hotcenplotz.mapper;

import com.hotcenplotz.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:08
 * @description: 员工信息
 */


@Mapper
public interface EmployeeMapper {
    // -------------------------------------原始分页查询--------------------------
    
    /**
     * 总记录数
     */

    @Select("select count(*) from tlias.employee")
    Long count();


    /**
     * 分页查询方法
     */

//    @Select("""
//        select
//            emp.id              as id,
//            emp.username        as username,
//            emp.password        as password,
//            emp.name            as name,
//            emp.gender          as gender,
//            emp.phone           as phone,
//            emp.job             as job,
//            emp.salary          as salary,
//            emp.image           as image,
//            emp.entry_date      as entryDate,
//            emp.created_at      as createdAt,
//            emp.updated_at      as updatedAt,
//            emp.department_id   as departmentId,
//            dpt.name            as departmentName
//        from employee emp
//        left join department dpt
//        on(emp.department_id = dpt.id)
//        order by emp.updated_at desc
//        limit #{start}, #{pageSize}
//
//    """)
//    List<Employee> list(
//        @Param("start") Integer start,
//        @Param("pageSize") Integer pageSize
//    );
//
    
    @Select("""
        select
            emp.id              as id,
            emp.username        as username,
            emp.password        as password,
            emp.name            as name,
            emp.gender          as gender,
            emp.phone           as phone,
            emp.job             as job,
            emp.salary          as salary,
            emp.image           as image,
            emp.entry_date      as entryDate,
            emp.created_at      as createdAt,
            emp.updated_at      as updatedAt,
            emp.department_id   as departmentId,
            dpt.name            as departmentName
        from employee emp
        left join department dpt
        on(emp.department_id = dpt.id)
        where emp.name like concat('%',#{name},'%')
            and emp.gender = #{gender}
            and emp.entry_date between #{begin} and #{end}
        order by emp.updated_at desc
        limit #{start}, #{pageSize}

    """)
    List<Employee> list(
        @Param("start") Integer start,
        @Param("pageSize") Integer pageSize,
        @Param("name") String name,
        @Param("gender") Integer gender,
        @Param("begin") LocalDate begin,
        @Param("end") LocalDate end
    );

//    // ------------------------ PageHelper 分页查询 ----------------------
//
//    @Select("""
//        select
//            emp.id              as id,
//            emp.username        as username,
//            emp.password        as password,
//            emp.name            as name,
//            emp.gender          as gender,
//            emp.phone           as phone,
//            emp.job             as job,
//            emp.salary          as salary,
//            emp.image           as image,
//            emp.entry_date      as entryDate,
//            emp.created_at      as createdAt,
//            emp.updated_at      as updatedAt,
//            emp.department_id   as departmentId,
//            dpt.name            as departmentName
//        from employee emp
//        left join department dpt on emp.department_id = dpt.id
//        order by emp.updated_at desc
//    """)
//    public List<Employee> list();

}
