package com.iamhotcenplotz.chapter23.reflection.class_;

import com.iamhotcenplotz.chapter23.reflection.Car;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class HowToLoad_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String key = scanner.nextLine();

        switch (key){
            case "1":  // 静态加载，自己new，编译时加载
                Car car = new Car();
                String string = car.toString();
                System.out.println(string);
                break;
            case "2": // 动态加载，通过Class，运行时加载
                Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Car");
                Object obj = cls.getDeclaredConstructor().newInstance();
                Method method = cls.getMethod("toString");
                System.out.println(method.invoke(obj));
                break;
            default:
                System.out.println("nothing...");
                break;
        }
    }
}
