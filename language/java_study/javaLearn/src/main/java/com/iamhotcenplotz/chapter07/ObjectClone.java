package com.iamhotcenplotz.chapter07;

public class ObjectClone {
    public static void main(String[] args) {
        A a = new A();
        Clone clone = new Clone();
        A a2 = clone.clonePerson(a);


    }
}

class A {
    String name;
    int age;
}

class Clone{
    public A clonePerson(A a){
        A a1 = new A();
        a1.name = a.name;
        a1.age = a.age;
        return a1;
    }
}