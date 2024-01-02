package com.ciTask.mapper;

import com.ciTask.entity.Employee;
import com.ciTask.resource.EmployeeResource;

public class Mapper {

    // Convert Employee Entity into EmployeeResource
    public static EmployeeResource mapToEmployeeDto(Employee employee) {
        EmployeeResource userDto = new EmployeeResource();
        userDto.setEmpId(employee.getEmpId());
        userDto.setEmpFirstName(employee.getEmpFirstName());
        userDto.setEmpLastName(employee.getEmpLastName());
        userDto.setEmpEmail(employee.getEmpEmail());
        userDto.setEmpDepartment(employee.getEmpDepartment());
        userDto.setEmpSalary(employee.getEmpSalary());
        userDto.setEmpAddress(employee.getEmpAddress());
        userDto.setEmpPhoneNumber(employee.getEmpPhoneNumber());
        return userDto;
    }

    // Convert EmployeeResource into Employee Entity
    public static Employee mapToEmployee(EmployeeResource employeeDto) {
        Employee employee = new Employee();
        employee.setEmpId(employeeDto.getEmpId());
        employee.setEmpFirstName(employeeDto.getEmpFirstName());
        employee.setEmpLastName(employeeDto.getEmpLastName());
        employee.setEmpEmail(employeeDto.getEmpEmail());
        employee.setEmpDepartment(employeeDto.getEmpDepartment());
        employee.setEmpSalary(employeeDto.getEmpSalary());
        employee.setEmpAddress(employeeDto.getEmpAddress());
        employee.setEmpPhoneNumber(employeeDto.getEmpPhoneNumber());
        return employee;
    }
}

