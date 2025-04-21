package com.iamhotcenplotz.chapter22.server.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

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

    public Socket getSocket() {
        return socket;
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
                // 1. user 退出
                if(message.getMessageType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender() + " 退出");

                    // 将客户端对应的线程从集合中删除
                    ManageClientThreads.remove(message.getSender());

                    // 关闭socket
                    socket.close();

                    // 退出循环
                    break;

                }

                // 2. 获取在线好友列表
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

                // 3. 私聊转发
                if(message.getMessageType().equals(MessageType.MESSAGE_COMM_MSG)){
                    //根据message 获取receiver，然后再得到对应的线程
                    ServerConnectClientThread receiverThread = ManageClientThreads.getServerConnectClientThread(message.getReceiver());
                    //得到对应的socket对象输出流，将message对象转发给指定用户
                    ObjectOutputStream oos = new ObjectOutputStream(receiverThread.getSocket().getOutputStream());
                    oos.writeObject(message); // 转发，如果客户不在线，可以保存到数据库，实现离线留言。

                }

                // 4. 群聊转发
                if(message.getMessageType().equals(MessageType.MESSAGE_TO_ALL_MSG)){
                    //遍历所有线程，把消息转发
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();

                    while(iterator.hasNext()){
                        String onlineUserId = iterator.next();

                        if(!onlineUserId.equals(message.getSender())){
                            ServerConnectClientThread receiverThread = hm.get(onlineUserId);
                            ObjectOutputStream oos = new ObjectOutputStream(
                                receiverThread
                                .getSocket()
                                .getOutputStream()
                            );
                            oos.writeObject(message);
                        }
                    }
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}