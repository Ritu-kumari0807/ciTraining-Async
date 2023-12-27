package com.ciTask.controller;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.exception.PayslipAlreadyExistsException;
import com.ciTask.mapper.PayslipMapper;
import com.ciTask.resource.EmployeePayslipResource;
import com.ciTask.resource.EmployeeResource;
import com.ciTask.service.EmployeePayslipService;
import com.ciTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/payslip")
public class EmployeePayslipController {
    @Autowired
    private EmployeePayslipService employeePayslipService;
    @Autowired
    private EmployeeService employeeService;

    // Endpoint to generate payslip for an employee
    @PostMapping("/generate/{employeeId}")
    public ResponseEntity<?> generatePaySlip(@PathVariable Long employeeId) {
        try {

            // Check if the employee exists
            CompletableFuture<Employee> employeeFuture = employeeService.getEmployeeById(employeeId);

            // Handle the CompletableFuture result,This waits for the result
            Employee employee = employeeFuture.join();

            if (employee == null) {
                throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
            }

//            // Check if a payslip already exists for the employee
//            boolean payslipExists = employeePayslipService.checkPayslipExists(employeeId);
//
//            if (payslipExists) {
//                throw new PayslipAlreadyExistsException("Payslip already generated for Employee ID: " + employeeId);
//            }

            CompletableFuture<EmployeePayslip> generatedPaySlip = employeePayslipService.generatePaySlip(employeeId);
            return new ResponseEntity<>("generated payslip", HttpStatus.CREATED);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}