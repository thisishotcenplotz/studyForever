package com.iamhotcenplotz.chapter21.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * Server
 * 使用字符流
 */

@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        // 监听9999端口; 注意这里要求9999没有被占用，不然会报错。
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server Start and monitor 9999...");

        // 当有客户端连接9999端口时，程序会阻塞等待连接，并返回Socket对象，程序继续
        Socket socket = serverSocket.accept();
        System.out.println("Get a client...");

        // 获取socket 输入流
        InputStream inputStream = socket.getInputStream();

        // 用字符流读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = bufferedReader.readLine();
        System.out.println(data);

        // 获取输出流，并发送数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello Client3"); // 字符流
        bufferedWriter.newLine(); // 插入换行符，表示回复结束。
        bufferedWriter.flush(); // 手动刷新


        socket.shutdownOutput();


        // 关闭 input stream 并释放socket 资源
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
        System.out.println("server closed...");




    }
}
