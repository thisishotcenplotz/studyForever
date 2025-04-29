package com.iamhotcenplotz.chapter26.restaurant.bean;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 15:49
 * @description:
 */


public class DiningTable {
    private Integer id;
    private String status;
    private String order_name;
    private String order_tel;

    public DiningTable() {}

    public DiningTable(Integer id, String status, String order_name, String order_tel) {
        this.id = id;
        this.status = status;
        this.order_name = order_name;
        this.order_tel = order_tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_tel() {
        return order_tel;
    }

    public void setOrder_tel(String order_tel) {
        this.order_tel = order_tel;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", order_name='" + order_name + '\'' +
                ", order_tel='" + order_tel + '\'' +
                '}';
    }
}
