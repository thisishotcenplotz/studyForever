package com.iamhotcenplotz.chapter21.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * Client
 * 使用字符流
 */

@SuppressWarnings({"all"})
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {

        // 1. 链接服务器 localhost:9999
        Socket localhost = new Socket("localhost", 9999);
        System.out.println("链接成功...");

        // 2. get output stream
        OutputStream outputStream = localhost.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello Server3");

        // 3. 标记结束
        bufferedWriter.newLine(); // 插入换行符，表示写入内容结束；要求对方使用readLine(),不然读不到；
        bufferedWriter.flush(); // 手动刷新，不然数据不会写入数据通道

        // 4. 获取输入流并打印
        InputStream inputStream = localhost.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = bufferedReader.readLine();
        System.out.println(data);

        // 5. 关闭流 并 释放socket 资源
        bufferedReader.close();
        bufferedWriter.close();
        localhost.close();
        System.out.println("客户端退出成功...");

    }
}
