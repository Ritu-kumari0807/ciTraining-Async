package com.ciTask.controller;

import com.ciTask.entity.Employee;
import com.ciTask.resource.EmployeeAttendanceResource;
import com.ciTask.service.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {
    @Autowired
    private EmployeeAttendanceService employeeAttendanceService;

    //http://localhost:8080/api/attendance/addAttendance
    @PostMapping("/addAttendance/{id}")
    public ResponseEntity<EmployeeAttendanceResource> addEmployeeAttendance(@Valid @PathVariable Long id, @RequestBody EmployeeAttendanceResource employeeAttendanceResource) {
        EmployeeAttendanceResource createdAttendance = employeeAttendanceService.addEmployeeAttendance(id,employeeAttendanceResource);
        return new ResponseEntity<>(createdAttendance, HttpStatus.CREATED);
    }
}
