package com.iamhotcenplotz.chapter26.restaurant.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 17:21
 * @description:
 */


public class Bill {
    private Integer id;
    private String bill_id;
    private Integer menu_id;
    private Integer quantity;
    private BigDecimal unit_price;
    private Integer table_id;
    private LocalDateTime bill_date;
    private String payment_status;

    public Bill() {
    }

    public Bill(Integer id, String bill_id, Integer menu_id, Integer quantity, BigDecimal unit_price, Integer table_id, LocalDateTime bill_date, String payment_status) {
        this.id = id;
        this.bill_id = bill_id;
        this.menu_id = menu_id;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.table_id = table_id;
        this.bill_date = bill_date;
        this.payment_status = payment_status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public LocalDateTime getBill_date() {
        return bill_date;
    }

    public void setBill_date(LocalDateTime bill_date) {
        this.bill_date = bill_date;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
}
