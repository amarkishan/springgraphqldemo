package com.graphql.springgraphqldemo.repo;

import com.graphql.springgraphqldemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.OptionalDouble;

public interface Employeerepo extends JpaRepository<Employee,Integer>
{



}