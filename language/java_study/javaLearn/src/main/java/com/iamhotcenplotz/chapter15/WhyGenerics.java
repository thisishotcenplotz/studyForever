package com.iamhotcenplotz.chapter15;

import java.util.ArrayList;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class WhyGenerics {
    public static void main(String[] args) {

        // Tranditional Methods

        ArrayList arrayList = new ArrayList();

        arrayList.add(new Dog("Johnson",1));
        arrayList.add(new Dog("Karine",2));

        // 如果不小心添加了一只猫怎么办？
        // Oops...
//        arrayList.add(new Cat("Hedy",3));
//
//
//        for (Object o : arrayList) {
//            Dog d = (Dog) o;
//            System.out.println(d.getName());
//        }

        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("Johnson",1));
        dogs.add(new Dog("Karine",2));
        dogs.add(new Dog("Jim",3));

        for (Dog dog:dogs){
            System.out.println(dog.getName());
        }

        // Oops... sorry hedy.
//        dogs.add(new Cat("Hedy",18));


    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}