package com.iamhotcenplotz.chapter15;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class UnderstandGenerics_ {
    public static void main(String[] args) {
        Person<String> helloWorld = new Person<String>("hello world");
        Person<Integer> integerPerson = new Person<Integer>(18);
        Person<Float> floatPerson = new Person<Float>(10.00f);


        System.out.println(helloWorld.f());
        System.out.println(integerPerson.f());
        System.out.println(floatPerson.f());
    }
}

// 泛型的作用是：可以在类声明时通过一个标识标识类中的某个属性的类型
// 或者是某个方法的返回值的类型，或者是参数类型

class Person<E> {
    E s; // E 表示s的数据类型，该数据的类型是在定制Person对象的时候指定的，即在编译期间就确定E的类型是什么。

    public Person(E s) { // E 也可以使参数类型
        this.s = s;
    }

    public E f(){ // E 也可以是返回类型
        return s;
    }
}
