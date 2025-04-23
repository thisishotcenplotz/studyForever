package com.iamhotcenplotz.chapter23.reflection.class_;

import com.iamhotcenplotz.chapter23.reflection.question.Cat;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 对Class类的特点进行梳理
 */
public class Class01_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 1. Class 也是类，因此也是继承的Object

        // 2. Class类对象不是new出来的，而是系统创建的, 是通过ClassLoader类加载Cat类的class对象
        Cat cat = new Cat();
        /**
         *     public Class<?> loadClass(String name) throws ClassNotFoundException {
         *         return loadClass(name, false);
         *     }
         */
        Class<?> aClass = Class.forName("com.iamhotcenplotz.chapter23.reflection.question.Cat");


        // 3. 对于某个类的Class对象，在内存中只有一份，因此类只加载一次
        Class<?> aClass1 = Class.forName("com.iamhotcenplotz.chapter23.reflection.question.Cat");
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());

        // 4. 每个类的实例都会记得自己是由哪个Class实例所产生
        Cat cat2 = new Cat();
        cat2.getClass();

        // 5. 通过Class可以完整地得到一个类的完整结构，通过一系列API
        Class<?> cls = Class.forName("");
        cls.getName();
        cls.getSuperclass();
        cls.getInterfaces();
        cls.getClassLoader();
        cls.getConstructor();
        cls.getDeclaredFields();
        cls.getMethod("");

        // 6.
    }
}