package com.hotcenplotz.web.userweb01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 10:50
 * @description:
 */


/**
 * 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime lastUpdate;
    
}
