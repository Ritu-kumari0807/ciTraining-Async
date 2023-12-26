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


//    @GetMapping("/{employeeId}")
//    public ResponseEntity<EmployeePayslip> getPayslipByEmployeeId(@PathVariable Long employeeId) {
//        // Fetch the payslip for the given employeeId
//        CompletableFuture<EmployeePayslip> payslipFuture = employeePayslipService.generatePaySlip(employeeId);
//
//        // Wait for the future result and return the payslip or handle exceptions
//        try {
//            EmployeePayslip payslip = payslipFuture.get(); // Wait for the result
//            if (payslip != null) {
//                return ResponseEntity.ok(payslip);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            // Handle exceptions here
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

}
