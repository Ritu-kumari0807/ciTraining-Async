package com.ciTask.controller;

import com.ciTask.entity.EmployeePayslip;
import com.ciTask.mapper.PayslipMapper;
import com.ciTask.resource.EmployeePayslipResource;
import com.ciTask.service.EmployeePayslipService;
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

    // Endpoint to generate payslip for an employee
    @PostMapping("/generate/{employeeId}")
    public ResponseEntity<?> generatePaySlip(@PathVariable Long employeeId) {
        CompletableFuture<EmployeePayslip> generatedPaySlip = employeePayslipService.generatePaySlip(employeeId);
        // Map the entity to DTO
        return new ResponseEntity<>("generated payslip", HttpStatus.CREATED);
    }
}
