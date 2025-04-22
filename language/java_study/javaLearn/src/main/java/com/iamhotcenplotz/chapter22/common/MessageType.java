package com.iamhotcenplotz.chapter22.common;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; // 登录成功
    String MESSAGE_LOGIN_FAILED = "2"; // 登录失败
    String MESSAGE_COMM_MSG = "3"; // 普通信息
    String MESSAGE_GET_ONLINE_FRIEND = "4"; //要求返回在线用户列表
    String MESSAGE_RETURN_ONLINE_FRIEND = "5"; // 返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
    String MESSAGE_TO_ALL_MSG = "7"; // 群发信息
    String MESSAGE_FILE_MSG = "8"; // 群发信息
}
