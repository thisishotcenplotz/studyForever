package com.iamhotcenplotz.chapter22.client.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类，提供和消息相关的服务方法
 */
public class MessageClientService {

    /**
     * @param content 内容
     * @param sender 发件人
     * @param receiver 收件人
     * */
    public void sendMessageToOne(String content, String sender, String receiver){
        // 构建Message
        Message msg = new Message();
        msg.setMessageType(MessageType.MESSAGE_COMM_MSG);
        msg.setSender(sender);
        msg.setReceiver(receiver);
        msg.setContent(content);
        msg.setSendTime(new Date().toString());
        System.out.println(sender + " 对 " + receiver + " 说：" + content);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                ManageClientConnectServerThread
                .getClientConnectServerThread(sender)
                .getSocket()
                .getOutputStream()
            );

            oos.writeObject(msg);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendMessageToAll(String content,String sender){
        // 构建Message
        Message msg = new Message();
        msg.setMessageType(MessageType.MESSAGE_TO_ALL_MSG);
        msg.setSender(sender);
        msg.setContent(content);
        msg.setSendTime(new Date().toString());
        System.out.println(sender + " 对大家说：" + content);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                ManageClientConnectServerThread
                .getClientConnectServerThread(sender)
                .getSocket()
                .getOutputStream()
            );

            oos.writeObject(msg);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
