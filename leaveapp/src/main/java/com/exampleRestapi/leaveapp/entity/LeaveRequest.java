package com.exampleRestapi.leaveapp.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "leave_requests")
@Data
public class LeaveRequest {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String leaveType;

	    private LocalDate startDate;

	    private LocalDate endDate;

	    private int days;

	    private String reason;

	    private String status;

	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;
}
