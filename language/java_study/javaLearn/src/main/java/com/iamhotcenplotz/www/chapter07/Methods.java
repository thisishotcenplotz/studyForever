package com.iamhotcenplotz.www.chapter07;

public class Methods {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "zhang san";
        person.age = 18;

        person.speak();

        person.cal01();

        person.cal02(1001);

        System.out.println(person.cal03(1, 2));

        int[][] map = {{1,2,3},{1,2,3},{1,2,3}};

        Tools tools = new Tools();
        tools.printArray(map);
        tools.printArray(map);
    }
}

class Person {
    String name;
    int age;

    //public: 表示方法是公开的
    //void: 表示方法没有返回值
    public void speak() {
        System.out.println("I'm a good person");
    }

    public void cal01() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    public void cal02(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    public int cal03(int n1, int n2) {
        return (n1 + n2);
    }
}

class Tools {
    public void printArray(int[][] map) {
        System.out.println("======");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }
}