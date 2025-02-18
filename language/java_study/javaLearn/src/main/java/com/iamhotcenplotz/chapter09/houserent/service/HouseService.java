package com.iamhotcenplotz.chapter09.houserent.service;

import com.iamhotcenplotz.chapter09.houserent.model.House;

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

    public boolean del(int id) {
        int index = -1;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i].getId() == id) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < totalHouses - 1; i++) {
            houses[i] = houses[i + 1];
        }

        houses[--totalHouses] = null;
        return true;

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

    public House findById(int id) {
        for (int i = 0; i < totalHouses; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }
}
