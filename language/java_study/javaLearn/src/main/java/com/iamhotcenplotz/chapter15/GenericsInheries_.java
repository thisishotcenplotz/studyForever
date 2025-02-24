package com.iamhotcenplotz.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class GenericsInheries_ {
    public static void main(String[] args) {

        // wrong...泛型不具有继承性
        // ArrayList<Objects> strings = new ArrayList<String>();

        // example
        ArrayList<Object> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        ArrayList<AA> a3 = new ArrayList<>();
        ArrayList<BB> a4 = new ArrayList<>();
        ArrayList<CC> a5 = new ArrayList<>();


        printCollections(a1);
        printCollections(a2);
        printCollections(a3);
        printCollections(a4);
        printCollections(a5);

        // List<? Extends AA> c

        // printCollections2(a1); //x
        // printCollections2(a2); //x
        // printCollections2(a3); //v
        // printCollections2(a4); //v
        // printCollections2(a5); //v


        // ist<? super AA> c

        //printCollections3(a1); // v
        //printCollections3(a2); // x
        //printCollections3(a3); // v
        //printCollections3(a4); // x
        //printCollections3(a5); // x


    }

    // List<?> 表示任意泛型类型都可以接收
    public static void printCollections(List<?> c){
        for (Object o : c) {
            System.out.println(o);
        }
    }

    // List<? extends AA> 表示了上限，可以接收AA或AA的子类
    // 规定了泛型的上限
    public static void printCollections2(List<? extends AA> c){
        for (Object o : c) {
            System.out.println();
        }
    }

    // List<? super CC> 支持AA类及AA的父类，不限于直接父类
    // 规定了泛型的下限
    public static void  printCollections3(List<? super AA> c){
        for (Object o : c) {
            System.out.println(o);
        }
    }



}

class AA {}

class BB extends AA {}

class CC extends BB {}



