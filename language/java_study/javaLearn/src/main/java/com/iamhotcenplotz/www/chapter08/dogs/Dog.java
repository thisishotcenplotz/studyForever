package com.iamhotcenplotz.www.chapter08.dogs;

public class Dog {
    String dogName;
    int dogAge;

    public Dog(String dogName, int dogAge) {
        this.dogName = dogName;
        this.dogAge = dogAge;
    }

    public void showInfo() {
        System.out.println(this.dogName + " " + this.dogAge);
    }
}
