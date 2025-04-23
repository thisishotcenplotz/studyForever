package com.iamhotcenplotz.chapter23.reflection.class_;


import com.iamhotcenplotz.chapter23.reflection.Car;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示class类常用方法
 */
public class Class02_ {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String classFullPath = "com.iamhotcenplotz.chapter23.reflection.Car";

        // 获取class 对象
        // <?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classFullPath);

        // 输出cls: 显示cls对象属于哪个Class对象 -> classFullPath
        System.out.println(cls);
        System.out.println(cls.getClass()); // 输出运行类型 -> java.lang.Class

        // 得到包名
        System.out.println(cls.getPackage().getName());

        // 得到全类名
        System.out.println(cls.getName());

        // 生成对象实例
        Car car = (Car)cls.getDeclaredConstructor().newInstance();
        System.out.println(car);

        // 通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));

        // 通过属性给属性赋值
        brand.set(car,"Benz");
        System.out.println(brand.get(car));

        // 遍历所有属性
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName()+":"+field.get(car));
        }

        //

    }
}
