package com.ciTask.service.impl;

import com.ciTask.dictionary.APIErrorCode;
import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
//import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.exception.InspireException;
import com.ciTask.repository.EmployeeAttendanceRepository;
import com.ciTask.repository.EmployeePayslipRepository;
import com.ciTask.repository.EmployeeRepository;
import com.ciTask.service.EmployeeAttendanceService;
import com.ciTask.service.EmployeePayslipService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeePayslipServiceImpl implements EmployeePayslipService {

    private final EmployeePayslipRepository employeePayslipRepository;
    private final EmployeeAttendanceRepository employeeAttendanceRepository;
    private final EmployeeAttendanceService employeeAttendanceService;
    private final EmployeeRepository employeeRepository;

    public EmployeePayslipServiceImpl(EmployeePayslipRepository employeePayslipRepository, EmployeeAttendanceRepository employeeAttendanceRepository, EmployeeAttendanceService employeeAttendanceService, EmployeeRepository employeeRepository) {
        this.employeePayslipRepository = employeePayslipRepository;
        this.employeeAttendanceRepository = employeeAttendanceRepository;
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
                .orElseThrow(() -> new InspireException(APIErrorCode.NOT_FOUND, "Employeee not found with ID: " + employeeId));

        EmployeePayslip paySlip = new EmployeePayslip();
        paySlip.setEpIssueDate(LocalDate.now());
        paySlip.setEpAmount(totalAmount);
        paySlip.setEmployee(employee);
        return CompletableFuture.completedFuture(employeePayslipRepository.save(paySlip));
    }

    // Scheduled method to generate payslips for employees with attendance
    @Scheduled(cron = "0 8 13 * * ?")
    public void generatePayslipsForEmployeesWithAttendance() {
        List<Employee> employeesWithAttendance = employeeAttendanceRepository.findAllEmployeesWithAttendance();

        for (Employee employee : employeesWithAttendance) {
            generatePaySlip(employee.getEmpId());
        }
    }
}