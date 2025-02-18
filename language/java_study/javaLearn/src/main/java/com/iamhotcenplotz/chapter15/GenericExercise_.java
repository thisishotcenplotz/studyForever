package com.iamhotcenplotz.chapter15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class GenericExercise_ {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        students.put("Hedy",new Student("Hedy",18));
        students.put("Lori",new Student("Lori",18));
        students.put("Daphne",new Student("Daphne",18));

        for (String key: students.keySet()) {
            Student student = students.get(key);
            System.out.println(student.getName());
        }

        // 迭代器 EntrySet
        Set<Map.Entry<String, Student>> entries = students.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }


}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
