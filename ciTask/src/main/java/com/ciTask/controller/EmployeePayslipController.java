package com.ciTask.controller;

import com.ciTask.dictionary.APIErrorCode;
import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
//import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.exception.InspireException;
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

    //http://localhost:8080/api/payslip/generate/{employeeId}
    @PostMapping("/generate/{employeeId}")
    public ResponseEntity<?> generatePaySlip(@PathVariable Long employeeId) {

        CompletableFuture<Employee> employeeFuture = employeeService.getEmployeeById(employeeId);
        Employee employee = employeeFuture.join();
        CompletableFuture<EmployeePayslip> generatedPaySlip = employeePayslipService.generatePaySlip(employeeId);
        return new ResponseEntity<>("generated payslip", HttpStatus.CREATED);

    }
}