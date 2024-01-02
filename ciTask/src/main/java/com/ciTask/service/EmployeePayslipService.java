package com.ciTask.service;

import com.ciTask.entity.EmployeePayslip;
import com.ciTask.exception.EmployeeNotFoundException;

import java.util.concurrent.CompletableFuture;

public interface EmployeePayslipService {

    /**
     * Asynchronously generates a payslip for the employee identified by the provided employee ID.
     * Calculates the total number of days present for the employee and computes the payslip amount based on
     * the specified salary per day.
     *
     * @param employeeId The unique identifier of the employee for whom the payslip is to be generated.
     * @return A CompletableFuture representing the asynchronous operation of generating the employee's payslip.
     */
    public CompletableFuture<EmployeePayslip> generatePaySlip(Long employeeId);

}
