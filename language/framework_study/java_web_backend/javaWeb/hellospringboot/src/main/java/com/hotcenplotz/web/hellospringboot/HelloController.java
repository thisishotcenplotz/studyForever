package com.hotcenplotz.web.hellospringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 08:55
 * @description:
 */


@RestController
public class HelloController {
    
    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("name : " + name);
        return "Hello " + name;
    }
    
    @RequestMapping("/random")
    public Integer total() {
        Random random = new Random();
        int result = random.nextInt();
        
        if (result < 0){
            System.out.println("Oops~~~");
            result = -result;
        }
        
        return result;
    }
}
