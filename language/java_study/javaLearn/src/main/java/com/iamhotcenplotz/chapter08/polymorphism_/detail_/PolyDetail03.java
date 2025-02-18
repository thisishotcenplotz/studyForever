package com.iamhotcenplotz.chapter08.polymorphism_.detail_;

public class PolyDetail03 {
    public static void main(String[] args) {
        Object obj = new Object();

        BB bb = new BB();

        System.out.println(bb instanceof BB);

        System.out.println(bb instanceof AA);

        System.out.println(bb instanceof Object);


    }
}

class AA {

}

class BB extends AA{

}