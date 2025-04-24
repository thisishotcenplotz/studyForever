package com.iamhotcenplotz.chapter23.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 演示如何通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    // 第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Person");

        //1. getName: 获取全类名
        System.out.println(cls.getName());

        //2. getSimpleName: 获取简单类名
        System.out.println(cls.getSimpleName());

        //3. getFields: 获取所有public修饰的属性，包含本类以及父类
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        //4. getDeclaredFields: 获取本类中所有的属性
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        //5. getMethods: 获取所有public修饰的方法，包含本类以及父类
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //6. getDeclaredMethods: 获取本类中所有的方法
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        //7. getConstructors: 获取所有public修饰的构造器，包含本类和父类
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        //8. getDeclaredConstructors: 获取本类中所有构造器
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }

        //9. getPackage: 以Package形式返回包信息
        System.out.println(cls.getPackage().getName());

        //10. getSuperClass: 以Class形式返回父类信息
        System.out.println(cls.getSuperclass().getName());

        //11. getInterfaces: 以Class[]形式返回所有接口信息
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }

        //12. getAnnotations: 以Annotation[] 形式返回所有注解信息
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
        }
    }


    // 第二组方法API
    @Test
    public void api_02() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Person");
        //第二组：java.lang.reflect.Field
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {

            //1. getModifiers:以int形式返回修饰符[说明：默认修饰符是0，public 是1，private 是 2，protected 是4，static 是 8，final 是16]
            System.out.println(declaredField.getModifiers());

            //2. getType:以Class形式返回类型
            System.out.println(declaredField.getType());

            //3. getName:返回属性名
            String name = declaredField.getName();
            System.out.println(name);

        }
    }


    // 第三组方法API
    @Test
    public void api_03() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Person");

        //第三组：java.lang.reflect.Methods
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            //1. getModifiers:以int形式返回修饰符[说明：默认修饰符是0，public 是1，private 是 2，protected 是4，static 是 8，final 是16]
            System.out.println(method.getModifiers());
            //2. getReturnType:以Class形式返回类型
            System.out.println(method.getReturnType());
            //3. getName:返回属性名
            System.out.println(method.getName());
            //4. getParameterTypes: 以Class[] 返回参数类型数组
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }
    }


    // 第四组方法API
    @Test
    public void api_04() throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.iamhotcenplotz.chapter23.reflection.Person");

        //第四组：java.lang.reflect.Constructor
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            //1. getModifiers:以int形式返回修饰符[说明：默认修饰符是0，public 是1，private 是 2，protected 是4，static 是 8，final 是16]
            System.out.println(constructor.getModifiers());
            //2. getName:返回属性名
            System.out.println(constructor.getName());
            //3. getParameterTypes: 以Class[] 返回参数类型数组
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }
    }
}

class A {
    public String hobby;

    public A() {
    }

    public void hi() {
    }
}

@Deprecated
class Person extends A implements IA, IB {
    public String name;
    protected int age;
    String job;
    private double salary;

    public Person() {
    }

    public Person(String name) {
    }

    public Person(String name, int age) {
    }


    public void m1() {
    }

    protected void m2() {
    }

    void m3() {
    }

    protected void m4() {
    }

}

interface IA {
}

interface IB {
}