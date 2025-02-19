package com.iamhotcenplotz.chapter15;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class Exercise_ {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Paul",200.00,new EmployeeDate(2000,9,9)));
        employees.add(new Employee("Sunning",220.00,new EmployeeDate(1980,10,10)));
        employees.add(new Employee("Hardy",180.00,new EmployeeDate(2002,11,11)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println(employees);
    }
}



class Employee {
    private String name;
    private double salary;
    private EmployeeDate birthday;

    public Employee(String name, Double salary, EmployeeDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeDate getBirthday() {
        return birthday;
    }

    public void setBirthday(EmployeeDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}


class EmployeeDate implements Comparable<EmployeeDate> {
    private int year;
    private int month;
    private int day;

    public EmployeeDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }


    @Override
    public int compareTo(EmployeeDate o) {
        int y = this.year - o.getYear();
        int m = this.month - o.getMonth();
        int d = this.day - o.getDay();
        if (y != 0) return y;
        if (m != 0) return m;
        return d;
    }

}