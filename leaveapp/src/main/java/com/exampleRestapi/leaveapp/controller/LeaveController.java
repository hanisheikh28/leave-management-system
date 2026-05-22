package com.exampleRestapi.leaveapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleRestapi.leaveapp.entity.LeaveRequest;
import com.exampleRestapi.leaveapp.security.JwtUtil;
import com.exampleRestapi.leaveapp.service.LeaveService;
@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
	
//	  @Autowired
//	    private LeaveRequestRepository repository;
//
//	  
//	  
//	@GetMapping("/pending")
//	    public List<LeaveRequest> pending() {
//
//	        return repository.findByStatus("PENDING");
//	    }
//	    
	    
	    
	    
	    @Autowired
	    private LeaveService service;
	    
	    @PostMapping("/apply")
	    public LeaveRequest applyLeave(

	            @RequestBody LeaveRequest request,
	            @RequestHeader("Authorization") String token) {

	        String jwt = token.substring(7);

	        String email = JwtUtil.extractEmail(jwt);

	        return service.applyLeaveByEmail(email, request);
	    }
	    
	    @GetMapping("/my/{empId}")
	    public List<LeaveRequest> myLeaves(
	    		@PathVariable Long empId) {
	    	return service.myLeaves(empId);
	    }
	    
	    
	    @PutMapping("/approve/{id}")
	    public LeaveRequest approve(
	    		@PathVariable Long id) {
	    	return service.approve(id);
	    }
	    
	    @PutMapping("/reject/{id}")
	    public LeaveRequest reject(
	    		@PathVariable Long id) {
	    	return service.reject(id);
	    }
	    @GetMapping("/pending")
	    @PreAuthorize("hasRole('MANAGER')")
	    public List<LeaveRequest> pendingLeaves() {
	        return service.pendingLeaves();
	    }
}
