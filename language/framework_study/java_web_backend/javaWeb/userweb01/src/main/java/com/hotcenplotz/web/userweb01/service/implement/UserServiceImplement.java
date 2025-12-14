package com.hotcenplotz.web.userweb01.service.implement;

import com.hotcenplotz.web.userweb01.bean.User;
import com.hotcenplotz.web.userweb01.dao.implement.UserDaoImplement;
import com.hotcenplotz.web.userweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 12:54
 * @description:
 */


@Component
public class UserServiceImplement implements UserService {
    
    @Autowired
    private UserDaoImplement userDaoImplement;
    
    /**
     * parse all user information.
     *
     * @return
     */
    public List<User> findAll() {
        List<String> all = userDaoImplement.findAll();
        
        return all.stream().map(
            line -> {
                String[] row = line.split(",");
                Integer id = Integer.parseInt(row[0]);
                String userName = row[1];
                String password = row[2];
                String name = row[3];
                Integer age = Integer.parseInt(row[4]);
                LocalDateTime lastLogin = LocalDateTime.parse(row[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                
                User user = new User(id, userName, password, name, age, lastLogin);
                return user;
            }
        ).toList();
    }
}
