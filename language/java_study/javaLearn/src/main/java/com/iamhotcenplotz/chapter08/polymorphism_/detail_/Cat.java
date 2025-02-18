package com.iamhotcenplotz.chapter08.polymorphism_.detail_;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("Cat eat fish");
    }
    public void catchMouse(){
        System.out.println("Cat catch mouse");
    }
}
