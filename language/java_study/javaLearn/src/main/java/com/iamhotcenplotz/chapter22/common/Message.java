package com.iamhotcenplotz.chapter22.common;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 消息类
 * 用于客户端和服务器端通信
 */
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // common message
    private String sender; // 发送者
    private String receiver; // 接收者
    private String content; // 消息内容
    private String sendTime; // 发送时间
    private String messageType;  // 消息类型 [可以在接口定义消息类型]
    // 拓展和文件相关的字段
    private byte[] fileBytes;
    private int fileLength = 0;
    private String fileDest;
    private String fileSrc;

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public String getFileDest() {
        return fileDest;
    }

    public void setFileDest(String fileDest) {
        this.fileDest = fileDest;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
