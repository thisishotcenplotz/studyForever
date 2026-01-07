package com.hotcenplotz.mapper;

import com.hotcenplotz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
