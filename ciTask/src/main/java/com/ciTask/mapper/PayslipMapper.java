package com.ciTask.mapper;

import com.ciTask.entity.EmployeePayslip;
import com.ciTask.resource.EmployeePayslipResource;

public class PayslipMapper {

    //    covert EmployeePayslip Entity into EmployeePayslip Resource
    public static EmployeePayslipResource mapToPayslipResource(EmployeePayslip employeePayslip) {
        EmployeePayslipResource payslipDto = new EmployeePayslipResource();
        payslipDto.setEpId(employeePayslip.getEpId());
        payslipDto.setEpEmployeeId(employeePayslip.getEpEmployeeId());
        payslipDto.setEpIssueDate(employeePayslip.getEpIssueDate());
        payslipDto.setEpAmount(employeePayslip.getEpAmount());
        payslipDto.setEmployee(employeePayslip.getEmployee());
        return payslipDto;
    }

    //    covert EmployeePayslip Resource into EmployeePayslip Entity
    public static EmployeePayslip mapToPayslip(EmployeePayslipResource employeePayslipResource) {
        EmployeePayslip payslip = new EmployeePayslip();
        payslip.setEpId(employeePayslipResource.getEpId());
        payslip.setEpEmployeeId(employeePayslipResource.getEpEmployeeId());
        payslip.setEpIssueDate(employeePayslipResource.getEpIssueDate());
        payslip.setEpAmount(employeePayslipResource.getEpAmount());
        payslip.setEmployee(employeePayslipResource.getEmployee());
        return payslip;
    }
}
