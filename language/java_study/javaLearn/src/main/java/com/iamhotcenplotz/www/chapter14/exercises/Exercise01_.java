package com.iamhotcenplotz.www.chapter14.exercises;

import java.util.ArrayList;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise01_ {
    public static void main(String[] args) {

        ArrayList<News> news = new ArrayList<>();
        news.add(new News("xxx病毒确诊病例超千万，数百万印度教新图奔赴横河\"圣洗浴\"引发民众担忧"));
        news.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        for (int i = news.size() -1; i >=0 ; i--) {
            News temp = news.get(i);
            System.out.println(processTitle(temp.getTitle()));
        }


    }

    public static String processTitle(String title) {
        if (title == null){
            return "";
        }

        if(title.length() > 15){
            return title.substring(0, 15) + "...";
        }else {
            return title;
        }
    }
}


class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Title: " + this.title;
    }
}