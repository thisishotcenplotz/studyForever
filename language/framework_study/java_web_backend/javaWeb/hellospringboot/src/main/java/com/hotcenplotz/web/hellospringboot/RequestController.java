package com.hotcenplotz.web.hellospringboot;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 10:03
 * @description:
 */


@RestController
public class RequestController {
    
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 1. 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式： " + method);
        
        // 2. 获取请求url地址
        String url = request.getRequestURL().toString();
        System.out.println("请求url： " + url);
        String requestURI = request.getRequestURI();
        System.out.println("请求 uri： " + requestURI);
        
        // 3. 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议： " + protocol);
        
        // 4. 获取请求参数 - name
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + "  age: " + age);
        
        // 5. 获取请求头 - Accept3
        String accept = request.getHeader("Accept");
        System.out.println("Accept: " + accept);
        
        return "ok";
    }
}
