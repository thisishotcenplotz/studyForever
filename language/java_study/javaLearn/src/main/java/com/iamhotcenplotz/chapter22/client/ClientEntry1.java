package com.iamhotcenplotz.chapter22.client;

import com.iamhotcenplotz.chapter22.client.view.View;

import java.io.IOException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class ClientEntry1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new View().mainMenu();
        System.out.println("退出..");

    }
}
