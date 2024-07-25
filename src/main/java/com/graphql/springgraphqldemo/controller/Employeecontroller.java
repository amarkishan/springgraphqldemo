package com.graphql.springgraphqldemo.controller;

import com.graphql.springgraphqldemo.entity.Employee;
import com.graphql.springgraphqldemo.repo.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
@Controller
public class Employeecontroller
{
    private static final Logger logger = LoggerFactory.getLogger(Employeecontroller.class);
    @Autowired
    private Employeerepo employeerepo;

    @QueryMapping
    public Employee employeeById(@Argument Integer id)
    {
        return employeerepo.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Employee> employees()
    {
        return  employeerepo.findAll();
    }

    @MutationMapping
    public Employee createEmployee(@Argument String name, @Argument  String department, @Argument Float salary)
    {
        try {
            Employee employee = new Employee(name, department, salary);
            return employeerepo.save(employee);
        }
        catch (Exception e)
        {

            logger.error("Error creating employee:{}",e.getMessage());
            throw  e;
        }
    }

    @MutationMapping
    public Employee updateEmployee(@Argument int id,@Argument String name,@Argument String department)
    {
        Employee employee = employeerepo.findById(id).orElseThrow(()->new RuntimeException("Employee  not found"));

        employee.setName(name);
        employee.setDepartment(department);
        employeerepo.save(employee);
        return employee;
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument int id)
    {
         employeerepo.deleteById(id);

        return true;

    }


}
