package com.exampleRestapi.leaveapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleRestapi.leaveapp.entity.Employee;
import com.exampleRestapi.leaveapp.entity.LeaveRequest;
import com.exampleRestapi.leaveapp.repository.EmployeeRepository;
import com.exampleRestapi.leaveapp.repository.LeaveRequestRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRequestRepository leaveRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public LeaveRequest applyLeaveByEmail(
			String email,
			LeaveRequest request ) {
		Employee emp = empRepo.findByEmail(email)
		        .orElseThrow(() -> new RuntimeException("Employee not found"));
	
		request.setEmployee(emp);
		request.setStatus("PENDING");
		
		return leaveRepo.save(request);
	}
	
	
	public List<LeaveRequest> myLeaves(Long empId){
		return leaveRepo.findByEmployeeId(empId);
	}

	public List<LeaveRequest> pendingLeaves(){
		return leaveRepo.findByStatus("PENDING");
	}
	
	public LeaveRequest approve(Long id) {
		LeaveRequest leave = 
				leaveRepo.findById(id).orElse(null);
		
		leave.setStatus("APPROVED");
		return leaveRepo.save(leave);
		
	}
	
	public LeaveRequest reject(Long id) {
		LeaveRequest leave = 
		leaveRepo.findById(id).orElse(null);
		leave.setStatus("REJECTED");
		
		return leaveRepo.save(leave);
		
	}
}
