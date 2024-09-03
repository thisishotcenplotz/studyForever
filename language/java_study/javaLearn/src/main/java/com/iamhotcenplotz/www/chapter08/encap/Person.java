package com.iamhotcenplotz.www.chapter08.encap;

public class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    public Person() {
    }

    public Person(String name, int age, double salary, String job) {
        this.setName(name);
        this.setAge(age);
        this.salary = salary;
        this.job = job;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("age must between 1~120");
            System.out.println("default age 18");
        }
        return this;
    }

    public Person setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public Person setJob(String job) {
        this.job = job;
        return this;
    }

    public void showInfo() {
        System.out.println(this.name + " " + this.age + " " + this.job + " " + this.salary);
    }
}
