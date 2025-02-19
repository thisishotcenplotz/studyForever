package com.iamhotcenplotz.chapter15;

import com.iamhotcenplotz.chapter08.super_.A;

import java.util.ArrayList;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class GenericsDetail_ {
    public static void main(String[] args) {
        // 1.在给泛型指定时不能为基本数据类型，只可以使引用类型。！！！
        ArrayList<Integer> integers = new ArrayList<Integer>();

        // Wrong!!!!
        //ArrayList<int> ints = new ArrayList<int>();

        // 2.
        // this is ok...
        // 因为E指定了Animal类型，构造器传入了一个 new Animal()
        Pig<Animal> animalPig = new Pig<Animal>(new Animal());

        Pig<Animal> animalPig1 = new Pig<>(new B());
    }
}


class Animal {}
class B extends Animal {}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }
}