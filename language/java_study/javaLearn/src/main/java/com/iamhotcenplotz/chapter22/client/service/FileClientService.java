package com.iamhotcenplotz.chapter22.client.service;

import com.iamhotcenplotz.chapter22.common.Message;
import com.iamhotcenplotz.chapter22.common.MessageType;

import java.io.*;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类完成文件传输服务
 */
public class FileClientService {
    /**
     *
     * @param src 源文件
     * @param dest 把文件传到对方哪个目录
     * @param senderId 发送者
     * @param receiverId 接收者
     */
    public void sendFileToOne(String src,String dest,String senderId,String receiverId) throws IOException {

        //  1. 读取SRC文件再封装到数组
        Message msg = new Message();
        msg.setMessageType(MessageType.MESSAGE_FILE_MSG);
        msg.setSender(senderId);
        msg.setReceiver(receiverId);
        msg.setFileSrc(src);
        msg.setFileDest(dest);

        // 2. 读取文件
        byte[] fileBytes = new byte[(int)new File(src).length()];
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(src);
            fis.read(fileBytes);

            msg.setFileBytes(fileBytes);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(fis != null){
                fis.close();
            }
        }

        System.out.println(
            "\n" + senderId + " 给 " + receiverId + " 发送文件：" + src
            + " 到对方电脑目录的：" + dest
        );

        // 发送
        ClientConnectServerThread thread = ManageClientConnectServerThread.getClientConnectServerThread(senderId);
        ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
        oos.writeObject(msg);

    }
}
