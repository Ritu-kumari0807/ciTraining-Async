package com.ciTask.repository;

import com.ciTask.entity.Employee;
import com.ciTask.entity.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Long> {
    List<EmployeeAttendance> findByEmployeeEmpId(Long empId);

    void deleteByEmployee(Employee employee);
}

