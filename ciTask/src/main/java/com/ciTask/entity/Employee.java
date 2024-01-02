package com.ciTask.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID", nullable = false)
    private Long empId;

    @NotBlank
    @Column(name = "EMP_FIRST_NAME")
    private String empFirstName;

    @NotBlank
    @Column(name = "EMP_LAST_NAME")
    private String empLastName;

    @Email
    @NotBlank
    @Column(name = "EMP_EMAIL", unique = true)
    private String empEmail;

    @NotBlank
    @Column(name = "EMP_DEPARTMENT")
    private String empDepartment;

    @Column(name = "EMP_SALARY")
    private double empSalary;

    @NotBlank
    @Column(name = "EMP_ADDRESS")
    private String empAddress;

    @NotBlank
    @Column(name = "EMP_PHONE")
    private String empPhoneNumber;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeAttendance> attendances;

    @OneToMany(mappedBy = "employee")
    private List<EmployeePayslip> payslips;

}
