package com.iamhotcenplotz.www.chapter08.polymorphism_.detail_;

import com.iamhotcenplotz.www.chapter08.super_.A;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("Cat eat fish");
    }
    public void catchMouse(){
        System.out.println("Cat catch mouse");
    }
}
