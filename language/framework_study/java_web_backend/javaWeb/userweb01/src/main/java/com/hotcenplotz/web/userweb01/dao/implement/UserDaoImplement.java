package com.hotcenplotz.web.userweb01.dao.implement;

import com.hotcenplotz.web.userweb01.dao.UserDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 12:53
 * @description:
 */

@Repository
public class UserDaoImplement implements UserDAO {
    
    public List<String> findAll() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        return bufferedReader.lines().toList();
    }
}
