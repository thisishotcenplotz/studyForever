package com.iamhotcenplotz.chapter08.extend_;

public class Pupil {
    public String name;
    public int age;
    private double score;

    public void setAge(int age) {
        this.age = age;
    }

    public void testing() {
        System.out.println("小学生" + " " + this.name + " 正在考数学");
    }

    public void showInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.score);
    }

}
