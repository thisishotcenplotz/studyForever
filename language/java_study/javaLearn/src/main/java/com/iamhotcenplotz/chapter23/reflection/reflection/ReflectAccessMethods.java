package com.iamhotcenplotz.chapter23.reflection.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: Der Hotcenplotz
 * @version: 1.0
 * @date: 2025-04-26 22:26
 * @description: 通过反射调用方法
 */


public class ReflectAccessMethods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取Boss
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.reflection.Boss");

        // 创建实例
        Object boss = cls.getDeclaredConstructor().newInstance();

        // 调用方法1
        Method hi = cls.getMethod("hi",String.class);
        hi.invoke(boss,"666啊");

        // 调用 static 方法
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true); //暴破
        System.out.println(say.invoke(boss, 10, "li si", 'a'));
    }
}

class Boss {
    private int age;
    private String name;

    public Boss(){}

    private static String say(int n, String s, char c){
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("Hi! " + s);
    }
}
