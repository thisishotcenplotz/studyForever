package com.iamhotcenplotz.www.chapter08.houserent.service;

import com.iamhotcenplotz.www.chapter08.houserent.model.House;

/**
 * 1. 定义House[]
 */
public class HouseService {
    private House[] houses;
    private int totalHouses = 0;
    private int idCounter = 0;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (totalHouses == houses.length) {
            System.out.println("数组已满，不能继续添加了...");
            return false;
        }

        houses[totalHouses++] = newHouse;
        newHouse.setId(idCounter++);
        return true;
    }
}
