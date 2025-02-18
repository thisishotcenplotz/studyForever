package com.iamhotcenplotz.chapter10.abstract_;

public class Abstract01_ {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract public void eat();

}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog eat bone...");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Cat eat fish...");
    }
}
