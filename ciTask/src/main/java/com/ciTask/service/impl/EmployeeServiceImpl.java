package com.ciTask.service.impl;

import com.ciTask.entity.Employee;
import com.ciTask.mapper.Mapper;
import com.ciTask.repository.EmployeeRepository;
import com.ciTask.resource.EmployeeResource;
import com.ciTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Adds a new employee based on the provided resource and returns the added employee resource.
    @Override
    public EmployeeResource addEmployee(EmployeeResource employeeResource) {
        Employee employee = Mapper.mapToEmployee(employeeResource);
        Employee savedEmployee = employeeRepository.save(employee);
        return Mapper.mapToEmployeeDto(savedEmployee);
    }

    // Asynchronously retrieves an employee by their id and returns CompletableFuture holding the retrieved Employee  .
    @Async
    @Override
    public CompletableFuture<Employee> getEmployeeById(Long employeeId) {
        return CompletableFuture.completedFuture(employeeRepository.findById(employeeId).orElse(null));
    }

}

