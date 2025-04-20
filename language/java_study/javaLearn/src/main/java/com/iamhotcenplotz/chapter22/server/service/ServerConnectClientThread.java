package com.iamhotcenplotz.chapter22.server.service;

import com.iamhotcenplotz.chapter22.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类对应的对象是和某个客户端保持通讯
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId; // 链接到服务端的用户ID

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        // 这里线程处于run状态，可以发送和接受消息
        while (true) {
            System.out.println("服务器和客户端保持通讯，读取数据..." + userId);
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
