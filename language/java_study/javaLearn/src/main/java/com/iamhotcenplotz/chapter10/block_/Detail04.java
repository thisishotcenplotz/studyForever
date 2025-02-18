package com.iamhotcenplotz.chapter10.block_;

public class Detail04 {
    public static void main(String[] args) {
        new Two();
    }
}

class One {
    private static int One = getOne();

    static {
        System.out.println("One static block ...");
    }
    {
        System.out.println("One normal block ...");
    }

    public One() {
        System.out.println("One constructor ...");
    }

    public static int getOne(){
        System.out.println("One getOne");
        return 100;
    }
}

class Two extends One {
    private static int two = getTwo();
    static {
        System.out.println("Two static block ...");
    }
    {
        System.out.println("Two normal block ...");
    }

    public Two() {
        System.out.println("Two constructor ...");
    }

    public static int getTwo(){
        System.out.println("Two getTwo");
        return 200;
    }
}

