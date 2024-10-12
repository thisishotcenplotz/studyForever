package com.iamhotcenplotz.www.chapter08.overwrite_;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say() {
        System.out.println(this.name + " " + this.age);
    }
}
