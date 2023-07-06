package com.example.exception.exception_handler.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.exception.exception_handler.error.EmployeeNotFoundException;
import com.example.exception.exception_handler.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null ||
            employee.getEmployeeId().isEmpty()) {
                employee.setEmployeeId(UUID.randomUUID().toString());
            }
        employees.add(employee);
            return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with Id: " + id));
    }
    
}
