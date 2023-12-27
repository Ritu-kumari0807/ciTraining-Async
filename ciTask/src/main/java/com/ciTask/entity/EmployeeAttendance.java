package com.ciTask.entity;
import com.ciTask.dictionary.EmployeeAttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_ATTENDANCE")
public class EmployeeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EA_ID")
    private Long eaId;

    @NotNull
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @NotNull
    @Column(name = "EA_DATE")
    private LocalDateTime emaDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "EA_STATUS")
    private EmployeeAttendanceStatus employeeAttendanceStatus;

    @Column(name = "EA_CREATEDAT")
    private LocalDateTime emaCreatedAt;

    @Column(name = "EA_UPDATEDAT")
    private LocalDateTime emaUpdatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Employee employee;

}



