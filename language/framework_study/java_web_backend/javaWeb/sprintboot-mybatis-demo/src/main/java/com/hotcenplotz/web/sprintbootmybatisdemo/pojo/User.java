package com.hotcenplotz.web.sprintbootmybatisdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-07 08:14
 * @description:
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
