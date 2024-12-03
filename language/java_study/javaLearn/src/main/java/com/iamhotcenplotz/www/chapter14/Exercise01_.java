package com.iamhotcenplotz.www.chapter14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise01_ {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Wison", 5));
        dogs.add(new Dog("Dom", 5));
        dogs.add(new Dog("Monet", 5));

        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        Iterator<Dog> iterator = dogs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
