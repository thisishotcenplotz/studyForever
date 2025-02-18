package com.iamhotcenplotz.chapter10.innerclass_;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}


class Outer05 {
    private int n1 = 99;

    public void f1(){
        Person person = new Person() {
            private int n1 = 199;
            @Override
            public void hi() {
                System.out.println("Anonymous hi...");
                System.out.println("Outer n1 = "+ Outer05.this.n1);
                System.out.println("Inner n1 = "+ n1);
            }
        };
        person.hi();


        new Person(){
            @Override
            public void hi() {
                System.out.println("Another hi...");
            }
        }.hi();
    }
}

class Person {
    public void hi(){
        System.out.println("Person hi...");
    }
}