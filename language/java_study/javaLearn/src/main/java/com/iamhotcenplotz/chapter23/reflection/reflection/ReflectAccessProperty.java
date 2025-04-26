package com.iamhotcenplotz.chapter23.reflection.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * @date 2025-04-26 22:12
 * 演示反射操作属性
 */

public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 1. 得到Student实例
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.reflection.Student");

        // 2. 创建对象
        Object student = cls.getDeclaredConstructor().newInstance();

        // 3. 使用反射得到 name 和 age
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null,"Zhang San"); // 因为name 是 static 的，所有设个null是可以的

        Field age = cls.getDeclaredField("age");
        age.set(student,20);

        System.out.println(student);
    }
}

class Student {
    public int age;
    private static String name;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
