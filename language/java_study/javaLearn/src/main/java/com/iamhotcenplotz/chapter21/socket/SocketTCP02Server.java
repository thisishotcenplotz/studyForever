package com.iamhotcenplotz.chapter21.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * Server
 */

@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        // 监听9999端口; 注意这里要求9999没有被占用，不然会报错。
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server Start and monitor 9999...");

        // 当有客户端连接9999端口时，程序会阻塞等待连接，并返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("Get a client...");

        // 获取socket 输入流
        InputStream inputStream = socket.getInputStream();

        // 获取输入
        byte[] buffer = new byte[1024];
        int readLine = 0;
        while ((readLine = inputStream.read(buffer)) != -1) {
            System.out.println("Client: " + new String(buffer, 0, readLine));
        }

        // 获取输出流，并发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client".getBytes());
        socket.shutdownOutput();


        // 关闭 input stream 并释放socket 资源
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("server closed...");




    }
}
