package com.graphql.springgraphqldemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee_graphql")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String department;
    @Column
    private  Float salary;

    public Employee()
    {
    }

    public Employee(String name, String department,  Float salary)
    {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public  double getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
