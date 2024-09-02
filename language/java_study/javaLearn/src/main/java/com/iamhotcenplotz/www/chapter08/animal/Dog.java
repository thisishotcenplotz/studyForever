package com.iamhotcenplotz.www.chapter08.animal;

public class Dog {
    String name;
    int age;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(int age) {
        this.age = age;
    }

    public Dog(String a, int i) {
        this.name = a;
        this.age = i;
    }

    public void showInfo() {
        System.out.println(this.name + " " + this.age);
    }
}
