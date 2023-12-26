package com.ciTask.service.impl;

import com.ciTask.dictionary.EmployeeAttendanceStatus;
import com.ciTask.entity.EmployeeAttendance;
import com.ciTask.mapper.AttendanceMapper;
import com.ciTask.repository.EmployeeAttendanceRepository;
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

    @Override
    public EmployeeAttendanceResource addEmployeeAttendance(EmployeeAttendanceResource employeeAttendanceResource) {

        EmployeeAttendance employeeAttendance = AttendanceMapper.mapToAttendance(employeeAttendanceResource);
        employeeAttendance.setEmaCreatedAt(LocalDateTime.now());
        employeeAttendance.setEmaUpdatedAt(LocalDateTime.now());
        employeeAttendance.setEmployee(employeeAttendanceResource.getEmployee());
        EmployeeAttendance savedAttendance = employeeAttendanceRepository.save(employeeAttendance);
        return AttendanceMapper.mapToAttendanceDto(savedAttendance);

    }

    @Override
    public int getNumberOfDaysPresent(Long employeeId) {
        List<EmployeeAttendance> attendances = employeeAttendanceRepository.findByEmployeeEmpId(employeeId);

        // Filter the attendance records to count the number of days the employee was marked as "PRESENT"
        long presentDays = attendances.stream()
                .filter(attendance -> attendance.getEmployeeAttendanceStatus() == EmployeeAttendanceStatus.PRESENT)
                .count();

        return (int) presentDays;
    }

}
