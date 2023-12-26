package com.ciTask.service;

import com.ciTask.entity.EmployeePayslip;

import java.util.concurrent.CompletableFuture;

public interface EmployeePayslipService {
//    EmployeePayslip generatePaySlip(Long employeeId);
public CompletableFuture<EmployeePayslip> generatePaySlip(Long employeeId);
}
