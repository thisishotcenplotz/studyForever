package com.iamhotcenplotz.www.chapter14.exercises;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
public class Exercise02_ {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Dodge",new BigDecimal("1000000.00")));
        cars.add(new Car("Ford",new BigDecimal("10000.00")));

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

class Car {
    private String name;
    private BigDecimal price;

    public Car(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
