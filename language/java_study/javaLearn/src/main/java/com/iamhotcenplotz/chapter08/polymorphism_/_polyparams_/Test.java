package com.iamhotcenplotz.chapter08.polymorphism_._polyparams_;

public class Test {
    public static void main(String[] args) {
        Employee[] employees = {
                new Worker("John Doe1", 20000.00),
                new Worker("John Doe2", 20000.00),
                new Manager("John Doe3", 20000.00,10000),
                new Manager("John Doe4", 20000.00,10000),
        };

        Test test = new Test();
        test.showEmpSalary(employees[1]);

    }

    public void showEmpSalary(Employee e){
        System.out.println(e.getSalary());

        if(e instanceof Manager){
            ((Manager) e).manage();
        }

        if(e instanceof Worker){
            ((Worker) e).work();
        }
    }
}
