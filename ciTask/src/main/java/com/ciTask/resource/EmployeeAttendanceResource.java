package com.ciTask.resource;
import com.ciTask.dictionary.EmployeeAttendanceStatus;
import com.ciTask.entity.Employee;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EmployeeAttendanceResource {

    private Long eaId;
    private Long employeeId;
    private LocalDateTime emaDate;
    private EmployeeAttendanceStatus employeeAttendanceStatus;
    private LocalDateTime emaCreatedAt;
    private LocalDateTime emaUpdatedAt;
    private Employee employee;

}

