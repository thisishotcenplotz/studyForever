package com.iamhotcenplotz.chapter19.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示object outputstream， 完成数据序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 序列化后，保存的文件格式不是纯文本
        String filePath = "./data.dat";


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        // 序列化数据
        oos.write(100);
        oos.writeBoolean(true);
        oos.writeChar('A');
        oos.writeDouble(9.5);
        oos.writeUTF("Hello World~");

        // Dog
        oos.writeObject(new Dog("dog",3));

        // close
        oos.close();

        System.out.println("done ~");

    }
}


class Dog implements Serializable {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}