package com.iamhotcenplotz.chapter22.client.service;

import com.iamhotcenplotz.chapter22.common.Message;

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

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
