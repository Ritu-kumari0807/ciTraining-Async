package com.ciTask.service.impl;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.repository.EmployeePayslipRepository;
import com.ciTask.repository.EmployeeRepository;
import com.ciTask.service.EmployeeAttendanceService;
import com.ciTask.service.EmployeePayslipService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeePayslipServiceImpl implements EmployeePayslipService {

    private final EmployeePayslipRepository employeePayslipRepository;
    private final EmployeeAttendanceService employeeAttendanceService;
    private final EmployeeRepository employeeRepository;

    public EmployeePayslipServiceImpl(EmployeePayslipRepository employeePayslipRepository, EmployeeAttendanceService employeeAttendanceService, EmployeeRepository employeeRepository) {
        this.employeePayslipRepository = employeePayslipRepository;
        this.employeeAttendanceService = employeeAttendanceService;
        this.employeeRepository = employeeRepository;
    }

    // Asynchronously generates a payslip for the given employee ID based on attendance and saves it.    @Async
    @Override
    public CompletableFuture<EmployeePayslip> generatePaySlip(Long employeeId) {
        int numberOfDaysPresent = employeeAttendanceService.getNumberOfDaysPresent(employeeId);
        double salaryPerDay = 1000.0;
        double totalAmount = numberOfDaysPresent * salaryPerDay;

        // Fetch the Employee entity by its ID
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));

        EmployeePayslip paySlip = new EmployeePayslip();
        paySlip.setEpEmployeeId(employeeId);
        paySlip.setEpIssueDate(LocalDate.now());
        paySlip.setEpAmount(totalAmount);
        paySlip.setEmployee(employee);

        return CompletableFuture.completedFuture(employeePayslipRepository.save(paySlip));
    }

//    // Checks if a payslip exists for the employee identified by the given ID.
//    public boolean checkPayslipExists(Long employeeId) {
//
//        List<EmployeePayslip> payslips = employeePayslipRepository.findByEmployeeEmpId(employeeId);
//        return !payslips.isEmpty();
//    }
}