package com.hotcenplotz;

import com.hotcenplotz.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }
    
}
