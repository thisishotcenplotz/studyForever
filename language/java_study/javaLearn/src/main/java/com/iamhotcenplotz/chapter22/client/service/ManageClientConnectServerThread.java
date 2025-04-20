package com.iamhotcenplotz.chapter22.client.service;

import java.util.HashMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 该类管理客户端连接到服务端的线程类
 */
public class ManageClientConnectServerThread extends Thread {
    private static HashMap<String,ClientConnectServerThread> hm= new HashMap<>();

    // 添加client
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread connected){
        hm.put(userId,connected);
    }

    // get client by userId
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

    // 删除client

}
