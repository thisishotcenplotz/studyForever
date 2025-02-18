package com.iamhotcenplotz.chapter14;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class StrongForLoop_ {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Java Programming", "Java Programming", 1990));
        books.add(new Book("Spring Boot", "Spring Boot", 1990));
        books.add(new Book("Spring MVC", "Spring MVC", 1990));

        Iterator<Book> iterator = books.iterator();

        // 增强for底层还是iterator
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
