package com.iamhotcenplotz.chapter23.reflection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * @date 2025-04-26 21:55
 */

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1. 先获取User对象
        Class<?> clsOne = Class.forName("com.iamhotcenplotz.chapter23.reflection.reflection.User");

        // 2. 通过public的无参构造器创建实例
        Object userOne = clsOne.getDeclaredConstructor().newInstance();
        System.out.println(userOne);

        // 3. 通过public 有参构造器创建实例
        Constructor<?> constructor = clsOne.getConstructor(String.class);
        Object userTwo = constructor.newInstance("Li si");
        System.out.println(userTwo);

        // 4. 通过非public有参构造器创建实例
        Constructor<?> declaredConstructor = clsOne.getDeclaredConstructor(int.class, String.class);
        // 反射面前，一切都是纸老虎。
        declaredConstructor.setAccessible(true); // 暴破[暴力破解]：使用反射可以访问private 构造器/方法/属性
        Object userThree = declaredConstructor.newInstance(20, "wang wu");
        System.out.println(userThree);
    }
}


class User {
    private int age;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}