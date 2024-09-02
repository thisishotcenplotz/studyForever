package com.iamhotcenplotz.www.chapter07;

public class This01 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("aaa", 18);
    }
}


class Dog {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(this.hashCode());
    }

    public void info() {
        System.out.println(this.name + " " + this.age);
    }
}