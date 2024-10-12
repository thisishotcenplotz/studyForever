package com.iamhotcenplotz.www.chapter08.polymorphism_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        // 向上转型：父类的引用指向子类的对象

        // 可以调用父类的所有成员（要遵守访问权限）
        // 但是不能调用子类特有的成员
        Animal animal = new Cat();
    }
}
