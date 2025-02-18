package com.iamhotcenplotz.chapter07;

public class Constructor {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan", 18);
        zhangsan.printInfo();
    }
}

class Student {
    String name;
    int age;

    public Student(String pName, int pAge) {
        name = pName;
        age = pAge;
    }

    public Student(String pName) {
        name = pName;
    }

    public Student(int pAge) {
        age = pAge;
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}