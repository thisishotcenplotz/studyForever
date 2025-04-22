package com.iamhotcenplotz.chapter23.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 引入反射问题
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 读取配置文件 re.properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/java/com/iamhotcenplotz/chapter23/re.properties"));

        String classFullPath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");

        // 传统方法使用不了，要用反射
        // 根据指定信息，创建Cat 并调用hi

        // (1) 加载类 <- 返回一个Class对象
        Class<?> cls = Class.forName(classFullPath);

        // (2) 通过 cls 得到加载的类的实例对象
        Object obj = cls.getDeclaredConstructor().newInstance();

        // (3) 通过cls得到要加载的方法
        Method m = cls.getMethod(method);

        // (4) 通过 m 来调用: 通过方法对象来调用方法。
        m.invoke(obj);

        // (5) get field
        Field name = cls.getField("name");
        name.get(obj);

        // (6) 构造器
        Constructor<?> constructor = cls.getConstructor();
        Constructor<?> constructor1 = cls.getConstructor(String.class, Integer.class);// 有参构造器，此处传入的是形参的类型的class



    }
}
