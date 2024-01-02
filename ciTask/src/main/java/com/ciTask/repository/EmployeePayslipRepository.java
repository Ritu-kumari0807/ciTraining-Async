package com.ciTask.repository;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeePayslip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayslipRepository extends JpaRepository<EmployeePayslip, Long> {
    List<EmployeePayslip> findByEmployeeEmpId(Long employeeId);
    void deleteByEmployee(Employee employee);
}

