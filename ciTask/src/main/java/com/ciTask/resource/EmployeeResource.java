package com.ciTask.resource;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmployeeResource {

    private Long empId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empDepartment;
    private double empSalary;
    private String empAddress;
    private String empPhoneNumber;
}
