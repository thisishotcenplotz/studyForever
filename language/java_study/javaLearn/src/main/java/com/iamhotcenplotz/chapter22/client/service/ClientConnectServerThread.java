package com.iamhotcenplotz.chapter22.client.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread {
    // 该线程需要持有Socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 因为Thread需要再后台和服务器保持通信，因此这里做成while
        while (true) {
            System.out.println("客户端线程，等待从服务器端发送的消息");
            try {

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject(); // 如果服务器没法信息，线程会阻塞在这里。

                // 判断message类型，做相应业务处理
                // 1. 返回在线用户列表
                if(message.getMessageType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n++++++++++当前在线用户列表++++++++++");
                    for (String user : onlineUsers) {
                        System.out.println("+ " + user);
                    }
                }

                // 2. 接收私聊消息
                if(message.getMessageType().equals(MessageType.MESSAGE_COMM_MSG)){
                    //把从服务器端转发的消息，显示到控制台即可
                    System.out.println(
                        "\n" + message.getSender() + " 对你说:" + message.getContent()
                    );
                }

                // 3. 接收群聊
                if(message.getMessageType().equals(MessageType.MESSAGE_TO_ALL_MSG)){
                    System.out.println(
                        "\n【" + message.getSender() + "】 对所有人说:" + message.getContent()
                    );
                }

                // 接收文件
                if(message.getMessageType().equals(MessageType.MESSAGE_FILE_MSG)){
                    System.out.println(
                        "\n" + message.getSender() + " 给 " + message.getReceiver() + " 发送文件到"
                        + message.getFileDest()
                    );

                    // 取出文件字节数组，并写入到指定位置
                    FileOutputStream fos = new FileOutputStream(message.getFileDest());
                    fos.write(message.getFileBytes());
                    fos.close();
                    System.out.println("\n文件保存成功");

                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
