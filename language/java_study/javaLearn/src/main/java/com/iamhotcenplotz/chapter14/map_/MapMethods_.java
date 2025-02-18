package com.iamhotcenplotz.chapter14.map_;

import java.util.HashMap;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class MapMethods_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("邓超",new Book("aaa","bbb"));
        hashMap.put("邓超","孙俪");
        hashMap.put("王宝强","马蓉");
        hashMap.put("宋喆","马蓉");
        hashMap.put("鹿晗","关晓彤");

        hashMap.remove("鹿晗");

        System.out.println(hashMap.size());

        System.out.println(hashMap.isEmpty());

        System.out.println(hashMap.get("王宝强"));

        hashMap.containsKey("aaa");

        hashMap.clear();

        System.out.println(hashMap);
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
