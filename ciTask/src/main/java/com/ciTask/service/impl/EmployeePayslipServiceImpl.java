package com.ciTask.service.impl;

import com.ciTask.entity.EmployeePayslip;
import com.ciTask.repository.EmployeePayslipRepository;
import com.ciTask.service.EmployeeAttendanceService;
import com.ciTask.service.EmployeePayslipService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeePayslipServiceImpl implements EmployeePayslipService {

        private final EmployeePayslipRepository employeePayslipRepository;
        private final EmployeeAttendanceService employeeAttendanceService;

    public EmployeePayslipServiceImpl(EmployeePayslipRepository employeePayslipRepository, EmployeeAttendanceService employeeAttendanceService) {
        this.employeePayslipRepository = employeePayslipRepository;
        this.employeeAttendanceService = employeeAttendanceService;
    }
//
@Async // Annotation to make the method asynchronous
@Override
public CompletableFuture<EmployeePayslip> generatePaySlip(Long employeeId) {
    int numberOfDaysPresent = employeeAttendanceService.getNumberOfDaysPresent(employeeId);
    double salaryPerDay = 1000.0;
    double totalAmount = numberOfDaysPresent * salaryPerDay;

    EmployeePayslip paySlip = new EmployeePayslip();
    paySlip.setEpEmployeeId(employeeId);
    paySlip.setEpIssueDate(LocalDate.now());
    paySlip.setEpAmount(totalAmount);

    return CompletableFuture.completedFuture(employeePayslipRepository.save(paySlip));
}
    }