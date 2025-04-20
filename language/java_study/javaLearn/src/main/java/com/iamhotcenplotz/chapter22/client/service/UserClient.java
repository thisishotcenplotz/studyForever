package com.iamhotcenplotz.chapter22.client.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;
import com.iamhotcenplotz.chapter22.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类完成用户登录验证和用户注册功能等
 */
public class UserClient {

    // 因为可能要在其他地方使用User 信息，所以做成属性
    private User u = new User();

    // Socket
    private Socket socket;

    // 去服务器检查用户信息是否合法
    public boolean checkUser(String userId,String pwd) throws IOException, ClassNotFoundException {
        boolean result = false;

        // 创建User对象
        u.setUserID(userId);
        u.setPasswd(pwd);

        // 链接服务端，发送User
        socket = new Socket(InetAddress.getByName("localhost"), 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);

        // 读取从服务端回复的Message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();

        // 判断返回信息
        if(ms.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            result = true;

            // 创建一个和服务器端保持通信的线程 -> ClientConnectServerThread
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();

            // 为了后面客户端的拓展，将线程放入到一个集合中。
            ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
            result = true;
        } else {
            // 如果登录失败则不能建立连接，并关闭socket
            socket.close();

        }

        return result;
    }

    // 向服务器请求在线用户列表
    public void onlineFriendList() throws IOException {
        // 构建一个Message
        Message message = new Message();
        message.setSender(u.getUserID());
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);

        // 发送给服务器
        OutputStream outputStream = ManageClientConnectServerThread.getClientConnectServerThread(
            u.getUserID()
        ).getSocket().getOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(message);
    }
}
