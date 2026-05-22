package com.exampleRestapi.leaveapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleRestapi.leaveapp.dto.LoginRequest;
import com.exampleRestapi.leaveapp.entity.Employee;
import com.exampleRestapi.leaveapp.service.EmployeeService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/register")
	public Employee register(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return service.login(request.getEmail(), request.getPassword());
	}
}
