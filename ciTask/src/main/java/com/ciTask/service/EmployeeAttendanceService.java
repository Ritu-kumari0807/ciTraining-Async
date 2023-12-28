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
    /**
     * Adds a new employee attendance record based on the provided EmployeeAttendanceResource.
     *
     * @param employeeAttendanceResource The resource containing details of the employee attendance to be added.
     * @return The resource representing the newly added employee attendance.
     */
    EmployeeAttendanceResource addEmployeeAttendance(Long id,EmployeeAttendanceResource employeeAttendanceResource);

    /**
     * Retrieves the number of days an employee was marked as present based on the provided employee ID.
     *
     * @param employeeId The id of the employee whose attendance records are to be checked.
     * @return The total count of days the employee was marked as present.
     */
    int getNumberOfDaysPresent(Long employeeId);
}
