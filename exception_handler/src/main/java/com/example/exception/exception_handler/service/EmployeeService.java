package com.example.exception.exception_handler.service;

import java.util.List;

import com.example.exception.exception_handler.model.Employee;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
