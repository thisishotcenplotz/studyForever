package com.iamhotcenplotz.www.chapter13.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise {
    public static void main(String[] args) {

        Book[] books = new Book[4];

        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅新",200);
        books[2] = new Book("斗罗大陆2",300);
        books[3] = new Book("Java从入门到放弃",400);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        System.out.println(Arrays.toString(books));


        Arrays.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });

        System.out.println(Arrays.toString(books));

    }
}
