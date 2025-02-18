package com.iamhotcenplotz.chapter07;

public class MethodsParameters {
    public static void main(String[] args) {
        Bee bee = new Bee();

        int[] arr = {1,2,3,4,5};
        bee.test100(arr);

        ThePerson thePerson = new ThePerson();

        bee.test200(thePerson);

        System.out.println(thePerson.age);
    }
}

class ThePerson{
    String name;
    int age;
}

class Bee{
    public void test100(int[] arr){
        arr[0] = 200;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void test200(ThePerson p){
        p.age = 200;

    }
}
