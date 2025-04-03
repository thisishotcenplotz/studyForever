package com.iamhotcenplotz.chapter21.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        // 1. 链接服务器 localhost:9999
        Socket localhost = new Socket("localhost", 9999);
        System.out.println("链接成功...");

        // 2. get output stream
        OutputStream outputStream = localhost.getOutputStream();

        // 3. 写数据
        outputStream.write("Hello, server".getBytes());
        System.out.println("写入数据...");

        // 4. 关闭流 并 释放socket 资源
        outputStream.close();
        localhost.close();
        System.out.println("客户端退出成功...");

    }
}
