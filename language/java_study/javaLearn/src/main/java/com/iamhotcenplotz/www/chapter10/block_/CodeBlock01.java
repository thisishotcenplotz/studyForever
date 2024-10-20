package com.iamhotcenplotz.www.chapter10.block_;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie avengers = new Movie("Avengers",12.99,"iron man");
    }
}

class Movie {

    private String name;
    private double price;
    private String director;

    // 无论调用哪个构造器创建对象，都会先调用代码块的内容
    // 代码块优先于构造器
    {
        System.out.println("打开屏幕");
        System.out.println("播放广告");
        System.out.printf("电影开始");
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
