package com.hotcenplotz;

import com.hotcenplotz.mapper.UserMapper;
import com.hotcenplotz.pojo.User;
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
    
    @Test
    public void testDeleteById() {
        Integer updatesCount = userMapper.deleteById(99);
        System.out.println("<== update counts: " + updatesCount);
    }
    
    @Test
    public void testAddUser() {
        User user = new User(11,"juechen_ji","dabaojian123","季绝尘",20);
        user.lastUpdateNow();
        
        Integer save = userMapper.save(user);
        
        System.out.println("<== save user: " + save);
    }
    
    @Test
    public void testUpdateUserAge() {
        User user = new User(11,"juechen_ji","dabaojian123","季绝尘",19);
        user.lastUpdateNow();
        
        userMapper.updateUserAge(user);
    }
}
