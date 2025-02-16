package com.iamhotcenplotz.www.chapter14;

import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();


        // Properties extend from HashTable
        // null for k or v of Properties are not allowed.

        // add
        properties.put("john",100);
        properties.put("rick",80);

        // Throw exception
        // properties.put("hello",null);

        System.out.println(properties);

        // get value by key.
        Object rick = properties.get("rick");
        System.out.println(rick);

        // get value by getProperties

        System.out.println(properties.getProperty("john"));

        //delete
        properties.remove("rick");


    }
}
