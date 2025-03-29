package com.iamhotcenplotz.chapter19.properties_;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class modifyProperties_ {
    public static void main(String[] args) throws IOException {
        String filePath = "./mysql.properties";

        Properties properties = new Properties();
        properties.load(new FileReader(filePath));

        // add
        properties.setProperty("user2", "zhang san");

        // modify
        properties.setProperty("pwd", "123abc");

        // persis
        properties.store(new FileWriter(filePath), null);
    }
}
