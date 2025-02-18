package com.iamhotcenplotz.chapter10.interface_;

public class Interface03 {
    public static void main(String[] args) {
        Mysql mysql = new Mysql();
        Oracle oracle = new Oracle();

        test(mysql);
        test(oracle);
    }

    public static void test(Database db){
        db.connect();
        db.disconnect();
    }
}
