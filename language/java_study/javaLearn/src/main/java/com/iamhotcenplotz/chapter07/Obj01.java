package com.iamhotcenplotz.chapter07;

public class Obj01 {
    public static void main(String[] args) {
        // 不利于数据的管理。
        String catOneName = "white";
        String catTwoName = "Flower";

        int catOneAge = 3;
        int catTwoAge = 5;

        String catOneColor = "w";
        String catTwoColor = "f";

        // Array
        // 无法体现数据类型。
        String[] catOne = {"White", "3", "w"};
        String[] catTwo = {"Flower", "5", "f"};

        // 都不好，不利于数据管理且效率低。--> 类与对象。
        Cat cat1 = new Cat();
        cat1.name = "White";
        cat1.age = 18;
        cat1.color = "w";
        cat1.weight = 10.1;

        Cat cat2 = new Cat();
        cat2.name = "flower";
        cat2.age = 20;
        cat2.color = "F";
        cat2.weight = 10.0;


    }
}

// solve the problem using Object

class Cat {
    // properties
    String name;
    int age;
    String color;
    double weight;
    String[] master;


    // methods
}
