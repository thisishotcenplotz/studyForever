package com.iamhotcenplotz.chapter23.reflection.class_;

import com.iamhotcenplotz.chapter23.reflection.Car;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示得到Class对象的六中方式
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 已知一个类的全类名，且该类在类路径下，可以通过Class类的静态方法forName() 获取
        // 通常配合配置文件一起使用
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Car");
        System.out.println(cls);

        // 2. 若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高
        // 多用于参数的传递
        System.out.println(Car.class);

        // 3. 已知某个类的实例，调用该实例的getClass() 方法获取Class对象
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        // 4. 通过类加载器来获得Class对象的方式
        // (1) 先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2) 通过类加载器获得Class对象
        // cls,cls3,cls4 其实是一个东西
        Class<?> cls4 = classLoader.loadClass("com.iamhotcenplotz.chapter23.reflection.Car");

        // 5. 基本数据类型（int,char,boolean,float,double,byte,long,shot）
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;

        // 6.基本数据类型对应的包装类
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        Class<Boolean> type2 = Boolean.TYPE;
    }
}
