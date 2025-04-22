package com.iamhotcenplotz.chapter22.client.view;

import com.iamhotcenplotz.chapter22.client.service.FileClientService;
import com.iamhotcenplotz.chapter22.client.service.MessageClientService;
import com.iamhotcenplotz.chapter22.client.service.UserClient;
import com.iamhotcenplotz.chapter22.client.utils.Utility;

import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 客户端菜单界面
 */
public class View {
    private boolean loop = true; //控制是否显示菜单
    private String key = ""; // 接收用户的键盘输入
    private UserClient userClient = new UserClient(); // 用于登录服务器 或 注册用户
    private MessageClientService messageClientService = new MessageClientService(); // 用于私聊或群聊
    private FileClientService fileClientService = new FileClientService(); // 用于传输文件

    // 主菜单
    public void mainMenu() throws IOException, ClassNotFoundException {
        while (loop) {
            System.out.println("++++++++++欢迎登录网络通信系统++++++++++");
            System.out.println("\t\t  1 登录系统");
            System.out.println("\t\t  9 退出系统");
            System.out.print("请输入你的选择：");

            key = Utility.readString(1);

            switch (key) {
                case "1":
                    // 获取用户信息
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd = Utility.readString(50);
                    // 发送用户数据到服务端，进行验证
                    if (userClient.checkUser(userId,pwd)) {
                        System.out.println("++++++++++欢迎 " + userId + " ++++++++++");
                        // 进入二级菜单

                        while (loop) {
                            System.out.println("++++++++++网络通信系统二级菜单(用户 " + userId + ")++++++++++");
                            System.out.println("\t\t  1 显示在线用户列表");
                            System.out.println("\t\t  2 群发消息");
                            System.out.println("\t\t  3 私聊消息");
                            System.out.println("\t\t  4 发送文件");
                            System.out.println("\t\t  9 退出系统");
                            System.out.print("请输入你的选择：");
                            String key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    userClient.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话:");
                                    String contentGroup = Utility.readString(100);
                                    messageClientService.sendMessageToAll(contentGroup,userId);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊的用户号(在线):");
                                    String receiver = Utility.readString(50);
                                    System.out.print("请输入想说的话:");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(content,userId,receiver);
                                    break;
                                case "4":
                                    System.out.print("请输入想发送文件的用户：");
                                    String r = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径：");
                                    String srcPath = Utility.readString(100);
                                    System.out.print("请输入对方要保存的路径：");
                                    String desPath = Utility.readString(100);
                                    fileClientService.sendFileToOne(srcPath,desPath,userId,r);
                                    break;
                                case "9":
                                    userClient.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("++++++++++登录失败++++++++++");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }

}
