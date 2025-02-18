package com.iamhotcenplotz.chapter08.polymorphism_.polyarr_;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + " my score is " + this.score;
    }

    public void study(){
        System.out.println("student "+ this.getName() + " is studying java...");
    }
}
