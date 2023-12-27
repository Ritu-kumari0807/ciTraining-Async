package com.ciTask.controller;

import com.ciTask.exception.EmployeeNotFoundException;
import com.ciTask.resource.EmployeeResource;
import com.ciTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8080/api/employee/add
    @PostMapping("/add")
    public ResponseEntity<EmployeeResource> createEmployee(@Valid @RequestBody EmployeeResource employeeDto) {

        EmployeeResource savedEmployee = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/employee/delete/{id}
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeeWithAttendanceAndPayslip(@PathVariable Long employeeId) {
        try {
            employeeService.deleteEmployeeWithAttendanceAndPayslip(employeeId);
            return new ResponseEntity<>("Employee and related records deleted successfully", HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting employee and related records", HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}