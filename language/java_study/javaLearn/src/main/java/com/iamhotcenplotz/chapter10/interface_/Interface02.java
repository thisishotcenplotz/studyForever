package com.iamhotcenplotz.chapter10.interface_;

public class Interface02 {
    public static void main(String[] args) {

    }
}


class A implements AInterface {

    @Override
    public void hi() {
        System.out.println("Hi~~~");
        System.out.println(AInterface.n1);
    }

    @Override
    public void ok() {
        System.out.println("A ok...");
        AInterface.cry();
    }
}
