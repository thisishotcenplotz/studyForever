package com.iamhotcenplotz.chapter08.encap;

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("len must be between 2~4");
        }
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("balance must greater than 20");
            this.balance = 0.0;
        }
    }

    public void setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("detal:000000");
            this.password = "000000";
        }
    }
}
