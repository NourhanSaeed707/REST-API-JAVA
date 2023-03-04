package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.*;

public interface EmployeeService {
     Employee saveEmployee(Employee employee);

     List<Employee> getAllEmployess();

     Employee getEmployeeById(long id);

     Employee updateEmployee(Employee employee, long id);

     void deleteEmployee(long id);
}
