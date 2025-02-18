package com.iamhotcenplotz.chapter08.polymorphism_;

public class Master {

    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Master feed animals
    public void feed(Animal animal, Food food) {
        System.out.println("master: " + name + " feed " + animal.getName() + " " + food.getName());
    }
}
