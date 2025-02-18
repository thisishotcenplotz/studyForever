package com.iamhotcenplotz.chapter08.encap;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("zhangsa").setAge(99).setJob("engineer").setSalary(50000);
        person.showInfo();

        Account account = new Account();
        account.setName("张三");
        account.setBalance(10000.0);
        account.setPassword("1234332");

        // which style is your favorite?

    }
}
