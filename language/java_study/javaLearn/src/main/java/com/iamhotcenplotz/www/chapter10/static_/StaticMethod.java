package com.iamhotcenplotz.www.chapter10.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Student tom = new Student("Tom");
        tom.payTuition(200.00);

        Student bob = new Student("Bob");
        Student.payTuition(200.00);

        Student.showTotalTuition();
    }
}

class Student {
    private String name;

    private static double tuition = 0;

    public Student(String name) {
        this.name = name;
    }

    public static void payTuition(double tuition) {
        Student.tuition += tuition;
    }

    public static void showTotalTuition(){
        System.out.println("total tuition:" + Student.tuition);
    }
}
