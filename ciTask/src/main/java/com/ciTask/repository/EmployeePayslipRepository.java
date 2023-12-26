package com.ciTask.repository;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface EmployeePayslipRepository extends JpaRepository<EmployeePayslip, Long> {

    }

