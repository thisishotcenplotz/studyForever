package com.iamhotcenplotz.chapter22.server.service;

import com.iamhotcenplotz.chapter22.client.service.ManageClientConnectServerThread;
import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

                // 根据Message的类型来处理
                // 1. 获取在线好友列表
                if(message.getMessageType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUsers = ManageClientThreads.getOnlineUsers();

                    // 构建一个Message
                    Message returnMessage = new Message();
                    returnMessage.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
                    returnMessage.setContent(onlineUsers);
                    returnMessage.setReceiver(message.getSender());

                    // 发送
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(returnMessage);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
