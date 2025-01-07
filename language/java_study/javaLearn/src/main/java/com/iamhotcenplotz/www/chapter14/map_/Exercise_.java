package com.iamhotcenplotz.www.chapter14.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Exercise_ {
    public static void main(String[] args) {
        HashMap employee = new HashMap();

        employee.put("1",new Employee("1","George",30000));
        employee.put("2",new Employee("2","Tide",20000));
        employee.put("3",new Employee("3","Johnson",8000));
        employee.put("4",new Employee("4","Billy",15000));

        // 1. Enhanced For
        Set set = employee.keySet();
        for (Object key : set) {
            Employee e = (Employee) employee.get(key);
            if (e.getSalary() > 18000){
                System.out.println(e.toString());
            }
        }

        // iterator
        Set set1 = employee.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();

            Employee value = (Employee) next.getValue();

            if(value.getSalary() > 18000){
                System.out.println(value.toString());
            }


        }
    }
}

class Employee{
    private String Id;
    private String Name;
    private int Salary;

    public Employee(String id, String name, int salary) {
        Id = id;
        Name = name;
        Salary = salary;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
