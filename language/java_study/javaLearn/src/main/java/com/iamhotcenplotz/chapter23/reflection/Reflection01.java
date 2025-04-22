package com.iamhotcenplotz.chapter23.reflection;

import com.iamhotcenplotz.chapter23.reflection.question.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 测试反射调用的性能，以及优化方案
 */
public class Reflection01 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        m1();
        m2();
    }

    // 传统方法
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法耗时：" + (end - start));
    }

    // 反射
    public static void m2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.question.Cat");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method hi = cls.getMethod("hi");

        // 优化
        hi.setAccessible(true);

        // 执行
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(obj);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射调用耗时：" + (end - start));

    }
}
