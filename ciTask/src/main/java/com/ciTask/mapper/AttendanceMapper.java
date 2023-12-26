package com.ciTask.mapper;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeeAttendance;
import com.ciTask.resource.EmployeeAttendanceResource;
import com.ciTask.resource.EmployeeResource;

public class AttendanceMapper {
    // Convert User Entity into UserDto
    public static EmployeeAttendanceResource mapToAttendanceDto(EmployeeAttendance employeeAttendance) {
        EmployeeAttendanceResource userDto = new EmployeeAttendanceResource();
        userDto.setEaId(employeeAttendance.getEaId());
        userDto.setEmployeeId(employeeAttendance.getEmployeeId());
        userDto.setEmaDate(employeeAttendance.getEmaDate());
        userDto.setEmployeeAttendanceStatus(employeeAttendance.getEmployeeAttendanceStatus());
        userDto.setEmployee(employeeAttendance.getEmployee());

        return userDto;
    }

    // Convert UserDto into User JPA Entity
    public static EmployeeAttendance mapToAttendance(EmployeeAttendanceResource employeeAttendanceResource) {
        EmployeeAttendance employeeAttendance = new EmployeeAttendance();
        employeeAttendance.setEaId(employeeAttendanceResource.getEaId());
        employeeAttendance.setEmployeeId(employeeAttendanceResource.getEmployeeId());
        employeeAttendance.setEmaDate(employeeAttendanceResource.getEmaDate());
        employeeAttendance.setEmployeeAttendanceStatus(employeeAttendanceResource.getEmployeeAttendanceStatus());
        employeeAttendance.setEmployee(employeeAttendanceResource.getEmployee());
        return employeeAttendance;
    }
}
