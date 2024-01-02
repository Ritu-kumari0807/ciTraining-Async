package com.ciTask.resource;

import com.ciTask.entity.Employee;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeePayslipResource {
    private Long epId;
    private LocalDate epIssueDate;
    private Double epAmount;
    private Employee employee;
}
