package com.hotcenplotz.web.userweb01.controller;

import com.hotcenplotz.web.userweb01.pojo.User;
import com.hotcenplotz.web.userweb01.service.implement.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 10:55
 * @description: User Information Controller
 */


@RestController
public class UserController {
    
    @Autowired
    private UserServiceImplement userService;
    
    @RequestMapping("/list")
    public List<User> list() throws Exception {
        return this.userService.findAll();
    }
}
