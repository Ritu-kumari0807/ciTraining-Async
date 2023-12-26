package com.ciTask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE_PAYSLIP")
public class EmployeePayslip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EP_ID")
    private Long epId;

    @Column(name = "EP_EMPLOYEE_ID")
    private Long epEmployeeId;

    @Column(name = "EP_ISSUE_DATE")
    private LocalDate epIssueDate;

    @Column(name = "EP_AMOUNT")
    private Double epAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Employee employee;
}
