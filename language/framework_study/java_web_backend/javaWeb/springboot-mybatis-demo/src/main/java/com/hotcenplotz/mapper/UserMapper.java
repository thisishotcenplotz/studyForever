package com.hotcenplotz.mapper;

import com.hotcenplotz.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-07 21:29
 * @description:
 */


@Mapper
public interface UserMapper {
    
    /**
     * 查询所有用户
     */
    @Select("select id, username, password, name, age, last_update from the_db.user")
    public List<User> findAll();
    
    /**
     * 根据ID删除user
     * @param id
     */
    @Delete("delete from the_db.user where id = #{id}")
    public Integer deleteById(Integer id);
    
    /**
     * 增加用户
     */
    
    @Insert("insert into the_db.user (id, username, password, name, age, last_update) values (#{id},#{username},#{password},#{name},#{age},#{last_update})")
    public Integer save(User user);
    
    /**
     * 修改用户信息
     */
    
    @Update("update the_db.user set age = #{age}, last_update = #{last_update} where id = #{id}")
    public Integer updateUserAge(User user);
    
}
