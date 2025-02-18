package com.iamhotcenplotz.chapter08.polymorphism_.polyarr_;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name,int age,double salary) {
        super(name,age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void teach(){
        System.out.println("teacher " + this.getName() + " is teaching...");
    }
}
