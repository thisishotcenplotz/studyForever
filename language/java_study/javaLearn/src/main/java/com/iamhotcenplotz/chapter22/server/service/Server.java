package com.iamhotcenplotz.chapter22.server.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;
import com.iamhotcenplotz.chapter22.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 服务器，监听9999，等待客户端连接，并保持通讯
 */
public class Server {
    private ServerSocket ss = null;

    public Server() throws IOException, ClassNotFoundException {
        try {
            System.out.println("服务端在 9999 监听");

            ss = new ServerSocket(9999); // 端口可以写在配置文件中

            while (true) {
                Socket socket = ss.accept();

                // 得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();

                // 得到socket 关联的输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                // 创建一个message，准备回复客户
                Message message = new Message();

                // 验证用户名密码
                if (u.getUserID().equals("100") && u.getPasswd().equals("123456")) {
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    // 回复客户端
                    oos.writeObject(message);

                    // 创建一个线程，和客户端保持通讯，并持有这个socket
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserID());
                    serverConnectClientThread.start();

                    // 把该线程对象放入集合进行管理
                    ManageClientThreads.addServerConnectClientThread(u.getUserID(), serverConnectClientThread);

                } else {
                    System.out.println(u.getUserID() + " 登录失败 " + u.getPasswd());
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAILED);
                    oos.writeObject(message);
                    socket.close();
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert ss != null;
            ss.close();
        }
    }

}
