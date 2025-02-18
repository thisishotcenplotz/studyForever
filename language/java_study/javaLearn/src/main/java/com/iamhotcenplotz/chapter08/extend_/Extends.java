package com.iamhotcenplotz.chapter08.extend_;

public class Extends {
    public static void main(String[] args) {

        NewPupil newPupil = new NewPupil();
        newPupil.name = "zhangsan";
        newPupil.age = 18;
        newPupil.setScore(100);

        NewGraduate newGraduate = new NewGraduate();
        newGraduate.name = "lisi";
        newGraduate.age = 20;
        newGraduate.setScore(100);

        newPupil.showInfo();
        newPupil.showInfo();

    }
}
