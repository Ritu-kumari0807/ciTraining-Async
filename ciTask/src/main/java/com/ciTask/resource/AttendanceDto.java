package com.ciTask.resource;

import com.ciTask.dictionary.EmployeeAttendanceStatus;
import com.ciTask.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

    private LocalDateTime emaDate;
    private EmployeeAttendanceStatus employeeAttendanceStatus;
    private LocalDateTime emaCreatedAt;
    private LocalDateTime emaUpdatedAt;

}
