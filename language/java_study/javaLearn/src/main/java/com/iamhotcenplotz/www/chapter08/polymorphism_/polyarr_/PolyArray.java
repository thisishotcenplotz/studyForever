package com.iamhotcenplotz.www.chapter08.polymorphism_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {

        Person[] persons = {
                new Person("John Doe", 23),
                new Student("John", 23, 100),
                new Student("Doe", 22, 100),
                new Teacher("John", 23, 10000.00),
                new Teacher("Doe", 23, 10000.00)
        };


        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());

            if(persons[i] instanceof Teacher){
                Teacher teacher = (Teacher) persons[i];
                teacher.teach();
            }

            if(persons[i] instanceof Student){
                Student student = (Student) persons[i];
                student.study();
            }
        }
    }
}
