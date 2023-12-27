package com.ciTask.service.impl;

import com.ciTask.dictionary.EmployeeAttendanceStatus;
import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeeAttendance;
import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.mapper.AttendanceMapper;
import com.ciTask.repository.EmployeeAttendanceRepository;
import com.ciTask.repository.EmployeeRepository;
import com.ciTask.resource.EmployeeAttendanceResource;
import com.ciTask.service.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {
    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Adds a new employee attendance record and returns the added attendance resource.
    @Override
    public EmployeeAttendanceResource addEmployeeAttendance(EmployeeAttendanceResource employeeAttendanceResource) {

        EmployeeAttendance employeeAttendance = AttendanceMapper.mapToAttendance(employeeAttendanceResource);
        employeeAttendance.setEmaCreatedAt(LocalDateTime.now());
        employeeAttendance.setEmaUpdatedAt(LocalDateTime.now());
        employeeAttendance.setEmployee(employeeAttendanceResource.getEmployee());
        EmployeeAttendance savedAttendance = employeeAttendanceRepository.save(employeeAttendance);
        return AttendanceMapper.mapToAttendanceDto(savedAttendance);

    }

    // Retrieves the number of days an employee was marked as present based on the given employee ID.
    // Throws EmployeeNotFoundException if the employee is not found.
    @Override
    public int getNumberOfDaysPresent(Long employeeId) throws EmployeeNotFoundException {

        List<EmployeeAttendance> attendances = employeeAttendanceRepository.findByEmployeeEmpId(employeeId);

        // Filter the attendance records to count the number of days the employee was marked as "PRESENT"
        long presentDays = attendances.stream()
                .filter(attendance -> attendance.getEmployeeAttendanceStatus() == EmployeeAttendanceStatus.PRESENT)
                .count();

        return (int) presentDays;
    }

}
