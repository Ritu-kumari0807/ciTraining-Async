package com.ciTask.service;

import com.ciTask.entity.EmployeeAttendance;
import com.ciTask.resource.EmployeeAttendanceResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface EmployeeAttendanceService {

    EmployeeAttendanceResource addEmployeeAttendance(EmployeeAttendanceResource employeeAttendanceResource);

//    int getNumberOfDaysPresent(Long employeeId);

//    @Async
//    CompletableFuture<List<EmployeeAttendanceResource>> getAttendancesByEmployeeId(Long employeeId);

    //    @Override
    //    public int getNumberOfDaysPresent(Long employeeId) {
    //        // Fetch employee attendance records by employeeId
    //        List<EmployeeAttendance> attendances = employeeAttendanceRepository.findByEmployeeId(employeeId);
    //
    //        long presentDays = attendances.stream()
    //                .filter(attendance -> attendance.getEmployeeAttendanceStatus() == EmployeeAttendanceStatus.PRESENT)
    //                .count();
    //
    //        return (int) presentDays;
    //    }
    int getNumberOfDaysPresent(Long employeeId);
}
