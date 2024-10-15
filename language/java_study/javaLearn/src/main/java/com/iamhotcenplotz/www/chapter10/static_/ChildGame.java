package com.iamhotcenplotz.www.chapter10.static_;

public class ChildGame {
    public static void main(String[] args) {
//        int count = 0;
        Child child = new Child("白骨精");
        child.join();
        child.count++;

        Child child1 = new Child("狐狸精");
        child1.join();
        child1.count++;
//        count++;

        Child child2 = new Child("老鼠精");
        child2.join();
        child2.count++;
//        count++;

        System.out.println(String.valueOf(Child.count));
//        System.out.println(String.valueOf(count));
    }
}

class Child {
    private String name;
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(this.name + " 加入了游戏...");
    }
}
