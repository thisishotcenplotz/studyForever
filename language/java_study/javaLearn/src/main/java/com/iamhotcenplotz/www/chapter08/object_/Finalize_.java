package com.iamhotcenplotz.www.chapter08.object_;

public class Finalize_ {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        bmw = null;
        System.gc();
    }
}


class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("hello~~~");
    }
}
