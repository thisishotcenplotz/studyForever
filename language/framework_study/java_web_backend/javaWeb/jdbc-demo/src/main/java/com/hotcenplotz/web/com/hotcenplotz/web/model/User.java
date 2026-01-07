package com.hotcenplotz.web.com.hotcenplotz.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-07 07:10
 * @description:
 */


@Data    // 自动生成getter setter
@NoArgsConstructor // 自动生成无参构造器
@AllArgsConstructor // 自动生成全参构造器
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime lastUpdate;
    
}
