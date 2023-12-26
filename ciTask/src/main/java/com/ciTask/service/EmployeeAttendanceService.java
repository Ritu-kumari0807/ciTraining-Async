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

    int getNumberOfDaysPresent(Long employeeId);
}
