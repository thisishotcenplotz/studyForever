package com.hotcenplotz.web.hellospringboot;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-12-14 10:26
 * @description:
 */


@RestController
public class ResponseController {
    /**
     * 方式一： HttpServletResponse 设置响应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        
        // 1. 响应状态码
        response.setStatus(401);
        
        // 2. 设置响应头
        response.setHeader("name","Der Hotcenplotz");
        
        // 3. 设置响应体
        response.getWriter().write("Hello response");
    }
    
    /**
     * 方式2 ResponseEntity - Spring中提供的方式
     * @return
     */
    @RequestMapping("response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity.status(401)
            .header("name","Hi")
            .body("<h1> Hello World! </h1>");
        

    }
}
