package com.iamhotcenplotz.chapter08.extend_;

public class Exercise {
    public static void main(String[] args) {
        PC pc = new PC(1024, 64, "Intel", "Mac");
        pc.printInfo();
    }
}

class Computer {
    private String cpu;
    private int ram;
    private int disk;


    public Computer(int disk, int ram, String cpu) {
        this.disk = disk;
        this.ram = ram;
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getDetails() {
        return "CPU: " + cpu + "\nRAM: " + ram + "\nDisk: " + disk;
    }
}

class PC extends Computer {
    private String brand;

    // 这里体现出继承设计的基本思想：
    // - 父类构造器完成父类属性初始化，
    // - 子类构造器完成子类属性的初始化
    public PC(int disk, int ram, String cpu, String brand) {
        super(disk, ram, cpu);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo(){
        System.out.println(this.getDetails());
        System.out.println(this.getBrand());
    }
}

