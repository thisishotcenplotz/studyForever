package com.iamhotcenplotz.www.chapter08.polymorphism_._polyparams_;

public class Manager extends Employee{
    private double bones;

    public Manager(String name, double salary, double bones) {
        super(name, salary);
        this.bones = bones;
    }

    public double getBones() {
        return bones;
    }

    public void setBones(double bones) {
        this.bones = bones;
    }

    public void manage(){
        System.out.println("manager " + this.getName() + " is managing...");
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + this.bones;
    }
}
