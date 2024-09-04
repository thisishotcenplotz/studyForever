package com.iamhotcenplotz.www.chapter08.extend_;

public class Graduate {
    public String name;
    public int age;

    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("大学生" + " " + "正在考大学数学");
    }

    public void showInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.score);
    }
}
