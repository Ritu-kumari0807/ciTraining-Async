package com.ciTask.controller;

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
        public ResponseEntity<EmployeeResource> createEmployee(@Valid @RequestBody EmployeeResource employeeDto)  {

            EmployeeResource savedEmployee = employeeService.addEmployee(employeeDto);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }
    }
