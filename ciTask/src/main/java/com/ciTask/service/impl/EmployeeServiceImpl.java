package com.ciTask.service.impl;

import com.ciTask.dictionary.APIErrorCode;
import com.ciTask.entity.Employee;
//import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.exception.InspireException;
import com.ciTask.mapper.Mapper;
import com.ciTask.repository.EmployeeAttendanceRepository;
import com.ciTask.repository.EmployeePayslipRepository;
import com.ciTask.repository.EmployeeRepository;
import com.ciTask.resource.EmployeeResource;
import com.ciTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    @Autowired
    private EmployeePayslipRepository employeePayslipRepository;


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


    @Transactional
    @Override
    public void deleteEmployeeWithAttendanceAndPayslip(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new InspireException(APIErrorCode.NOT_FOUND, "Employeee not found with ID: " + employeeId));

//                 new EmployeeNotFoundException("Employee not found with ID: " + employeeId));

        // Delete attendance records related to the employee
        employeeAttendanceRepository.deleteByEmployee(employee);

        // Delete payslip records related to the employee
        employeePayslipRepository.deleteByEmployee(employee);

        // delete the employee
        employeeRepository.delete(employee);
    }
}



