package com.ciTask.service;

import com.ciTask.entity.Employee;
import com.ciTask.resource.EmployeeResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {

    /**
     * Adds a new employee based on the provided EmployeeResource.
     *
     * @param employeeResource The resource containing details of the employee to be added.
     * @return The resource representing the newly added employee.
     */
    EmployeeResource addEmployee(EmployeeResource employeeResource);

    /**
     * Retrieves an employee asynchronously by their id.
     *
     * @param employeeId The id of the employee to retrieve.
     * @return A CompletableFuture representing the asynchronous operation to retrieve the employee.
     *         The CompletableFuture holds the resulting Employee once the retrieval is complete.
     */
    @Async
    CompletableFuture<Employee> getEmployeeById(Long employeeId);
}
