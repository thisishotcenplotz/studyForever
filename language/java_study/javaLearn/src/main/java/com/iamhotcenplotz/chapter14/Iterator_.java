package com.iamhotcenplotz.chapter14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Iterator_ {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Java Programming", "Java Programming", 1990));
        books.add(new Book("Spring Boot", "Spring Boot", 1990));
        books.add(new Book("Spring MVC", "Spring MVC", 1990));

        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book next =  iterator.next();
            System.out.println(next);

        }
        
        // 当退出while循环后，这些iterator指向最后的元素，这时继续next的话会抛异常
        
        // 如果希望再次遍历，需要重置迭代器
        iterator = books.iterator();

        while (iterator.hasNext()) {
            Book next =  iterator.next();
            System.out.println(next);

        }

    }
}


class Book {
    private String name;
    private String author;
    private int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.author + ", " + this.price;
    }
}