package com.iamhotcenplotz.chapter21.api;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * InetAddress Demonstration
 */

public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        // get localhost
        //return -> hostname/ip address
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // get ip address by hostname
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        //get ip by domain name
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        // get ip by InetAddress
        System.out.println(byName.getHostAddress());

        // get hostname by InetAddress
        System.out.println(byName.getHostName());

    }
}
