package com.iamhotcenplotz.chapter14.exercises;

import java.util.TreeSet;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise05_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();

        // 因为Person 没有实现Comparable接口，所以这里会报错。
        treeSet.add(new Person());
    }
}

class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public String toString() {
        return "";
    }
}
