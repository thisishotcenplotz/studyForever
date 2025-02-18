package com.iamhotcenplotz.chapter14.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Sort_ {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("红楼梦", "曹雪芹", 99));
        books.add(new Book("西游记", "吴承恩", 88));
        books.add(new Book("水浒传", "施耐庵", 77));
        books.add(new Book("三国演义", "罗贯中", 66));
        books.add(new Book("斗罗大陆", "唐家三少", 11));

//        books.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getPrice() - o1.getPrice();
//            }
//        });
//
//        for (Book book : books) {
//            System.out.println(book);
//        }

        sort(books);
        for (Book book : books) {
            System.out.println(book);
        }

    }

    public static void sort(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Book o = (Book)list.get(j);
                Book o1 = (Book)list.get(j+1);

                if(o.getPrice() > o1.getPrice()){
                    list.set(j,o1);
                    list.set(j+1,o);
                }
            }
        }
    }
}

class Book {
    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
