package com.ciTask.service;

import com.ciTask.entity.Employee;
import com.ciTask.resource.EmployeeResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {
    EmployeeResource addEmployee(EmployeeResource employeeResource);

    @Async
    CompletableFuture<Employee> getEmployeeById(Long employeeId);
}
