package com.iamhotcenplotz.www.chapter08;

import com.iamhotcenplotz.www.chapter08.animal.Dog;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 32, 4, 2413, 34, 45};
        MyTools myTools = new MyTools();
        myTools.bubbleSort(arr); //引用传递

        Dog a = new Dog("a", 18);
        a.showInfo();

        com.iamhotcenplotz.www.chapter08.dogs.Dog b = new com.iamhotcenplotz.www.chapter08.dogs.Dog("b", 12);
        b.showInfo();
        a.showInfo();
    }
}

class MyTools {

    public void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}

class Somebody{
    String name;
    int age;

    public Somebody() {
    }

    public Somebody(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Somebody(String name) {
        this.name = name;
    }

    public Somebody(int age) {
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
}
