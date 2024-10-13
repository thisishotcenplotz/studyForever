package com.iamhotcenplotz.www.chapter08.exercises;

public class Exercise01 {
    public static void main(String[] args) {
        Person[] people = {
                new Person("jack",40,"JavaEE Engineer"),
                new Person("john",30,"Data Engineer"),
                new Person("jane",10,"Python Engineer"),
                new Person("jason",20,"Frontend Engineer")
        };

        Person tmp = null;
        for (int i = 0; i < people.length -1; i++) {
            for (int j = 0; j < people.length -1 -i; j++) {

                if(people[i].getAge() < people[i+1].getAge()) {
                    tmp = people[i];
                    people[i] = people[i+1];
                    people[i+1] = tmp;

                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].toString());
        }
    }
}

class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
