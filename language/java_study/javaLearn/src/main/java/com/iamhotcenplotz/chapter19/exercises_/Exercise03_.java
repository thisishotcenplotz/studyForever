package com.iamhotcenplotz.chapter19.exercises_;

import java.io.*;
import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 读一个dog.properties
 * 写一个Dog
 * 序列化Dog 到 data.dat
 */
public class Exercise03_ {
    public static void main(String[] args) throws IOException {
        String fileName = "dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(fileName));


        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, (age), color);

        // write
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.dat"));
        oos.writeObject(dog);

        oos.close();

    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
