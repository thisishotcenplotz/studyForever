package com.iamhotcenplotz.chapter26.restaurant.bean;

import java.math.BigDecimal;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 16:52
 * @description:
 */


public class Menu {
    private Integer id;
    private String name;
    private String type;
    private BigDecimal price;

    public Menu() {
    }

    public Menu(Integer id, String name, String type, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
