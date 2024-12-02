package com.iamhotcenplotz.www.chapter13.arrays_;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price;
    }
}
