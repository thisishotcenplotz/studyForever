package com.iamhotcenplotz.chapter19.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * create configuration file using Properties
 */
public class writeProperties_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        // set
        properties.setProperty("charset","utf-8");
        properties.setProperty("user","zhang san");
        properties.setProperty("password","123456");

        // persistence
        properties.store(new FileOutputStream("./test.properties"), null);
    }
}
