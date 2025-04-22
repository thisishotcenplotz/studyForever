package com.iamhotcenplotz.chapter22.server.service;

import com.iamhotcenplotz.chapter22.client.utils.Utility;
import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class SendNewsToAll implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("请输入要推送的新闻[输入exit退出]：");
            String news = Utility.readString(1000);

            if("exit".equals(news)) {
                break;
            }

            // 构建一个消息
            Message msg = new Message();
            msg.setSender("服务器");
            msg.setContent(news);
            msg.setMessageType(MessageType.MESSAGE_TO_ALL_MSG);
            msg.setSendTime(new Date().toString());

            System.out.println(
               "\n" + "服务器给所有人推送消息：" + news
            );

            // 发送给所有人
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                ServerConnectClientThread client = hm.get(key);

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(client.getSocket().getOutputStream());
                    oos.writeObject(msg);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
