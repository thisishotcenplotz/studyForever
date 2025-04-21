package com.iamhotcenplotz.chapter22.server.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类用于管理和客户端通讯的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    // 添加
    public static void addServerConnectClientThread(String userId,ServerConnectClientThread connected){
        hm.put(userId,connected);
    }

    // 获取
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    // 返回在线用户列表
    public static String getOnlineUsers(){
        StringBuilder onlineUsers = new StringBuilder();
        for (String s : hm.keySet()) {
            onlineUsers.append(s).append(" ");
        }
        return onlineUsers.toString();
    }

    public static void remove(String userId) {
        hm.remove(userId);
    }
}
