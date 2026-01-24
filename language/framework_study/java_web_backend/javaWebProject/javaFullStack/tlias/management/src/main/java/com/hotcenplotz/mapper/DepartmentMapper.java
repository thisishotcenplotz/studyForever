package com.hotcenplotz.mapper;

import com.hotcenplotz.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-24 10:25
 * @description:
 */


@Mapper
public interface DepartmentMapper {
    
//    @Select("select id,name,created_at as createdAt,updated_at as updatedAt from tlias.department order by updated_at desc;")
    @Select("select id,name,created_at,updated_at from tlias.department order by updated_at desc;")
    public List<Department> findAll();
    
    @Delete("delete from tlias.department where id = #{id};")
    void deleteByID(Integer depId);
    
    
    @Insert("insert into tlias.department (name,created_at,updated_at) values (#{name},now(),now());")
    void add(Department department);
    
    @Select("select id,name,created_at,updated_at from tlias.department where id = #{id}")
    Department getById(Integer id);
}
