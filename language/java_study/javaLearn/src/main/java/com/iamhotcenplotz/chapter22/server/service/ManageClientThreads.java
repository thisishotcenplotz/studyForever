package com.iamhotcenplotz.chapter22.server.service;

import java.util.HashMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类用于管理和客户端通讯的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    // 添加
    public static void addServerConnectClientThread(String userId,ServerConnectClientThread connected){
        hm.put(userId,connected);
    }

    // 获取
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }
}
