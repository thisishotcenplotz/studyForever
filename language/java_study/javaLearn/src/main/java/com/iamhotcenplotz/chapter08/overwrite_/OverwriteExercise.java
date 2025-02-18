package com.iamhotcenplotz.chapter08.overwrite_;

public class OverwriteExercise {
    public static void main(String[] args) {
        OverwritePerson person = new OverwritePerson("Lisi", 20);
        OverwriteStudent student = new OverwriteStudent("zhangsan", 18, 1, 22.2);

        person.say();
        student.say();


    }
}

class OverwritePerson {
    private String name;
    private int age;

    public OverwritePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() {
        return "name = " + this.name + ", age = " + this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class OverwriteStudent extends OverwritePerson {
    private int id;
    private double score;

    public OverwriteStudent(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        //这里体现了super的好处
        return super.say() + ", id = " + this.id + ", score = " + this.score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
