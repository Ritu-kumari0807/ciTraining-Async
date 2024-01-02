package com.ciTask.mapper;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeeAttendance;
import com.ciTask.resource.EmployeeAttendanceResource;
import com.ciTask.resource.EmployeeResource;

public class AttendanceMapper {

    // Convert Attendance Entity into Attendance Resource
    public static EmployeeAttendanceResource mapToAttendanceDto(EmployeeAttendance employeeAttendance) {
        EmployeeAttendanceResource userDto = new EmployeeAttendanceResource();
        userDto.setEmaDate(employeeAttendance.getEmaDate());
        userDto.setEmployeeAttendanceStatus(employeeAttendance.getEmployeeAttendanceStatus());
        userDto.setEmployee(employeeAttendance.getEmployee());
        return userDto;
    }

    // Convert Attendance Resource  into Attendance Entity
    public static EmployeeAttendance mapToAttendance(EmployeeAttendanceResource employeeAttendanceResource) {
        EmployeeAttendance employeeAttendance = new EmployeeAttendance();
        employeeAttendance.setEmaDate(employeeAttendanceResource.getEmaDate());
        employeeAttendance.setEmployeeAttendanceStatus(employeeAttendanceResource.getEmployeeAttendanceStatus());
        employeeAttendance.setEmployee(employeeAttendanceResource.getEmployee());
        return employeeAttendance;
    }
}
