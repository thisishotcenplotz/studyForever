package com.iamhotcenplotz.chapter14.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class LinkedHashSet_ {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add("aaa");
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(123);
        System.out.println(linkedHashSet);
    }
}

class Customer{
    private String name;
    private int number;

    public Customer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return number == customer.number && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}