package com.iamhotcenplotz.chapter19.properties_;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * read properties file demo
 */
public class NewWayProperties_ {
    public static void main(String[] args) throws IOException {
        String filePath = "./mysql.properties";
        Properties properties = new Properties();

        //load
        properties.load(new FileReader("./mysql.properties"));

        //show
        properties.list(System.out);

        // get
        String user = properties.getProperty("user");
        String password = properties.getProperty("pwd");

        System.out.println(user + ":" + password);
    }
}
