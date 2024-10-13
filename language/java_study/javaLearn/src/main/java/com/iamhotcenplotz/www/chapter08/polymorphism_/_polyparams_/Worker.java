package com.iamhotcenplotz.www.chapter08.polymorphism_._polyparams_;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work(){
        System.out.println("worker" + this.getName() + " is working...");
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary();
    }
}
