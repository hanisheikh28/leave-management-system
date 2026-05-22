package com.exampleRestapi.leaveapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exampleRestapi.leaveapp.entity.Employee;
import com.exampleRestapi.leaveapp.exception.ResourceNotFoundException;
import com.exampleRestapi.leaveapp.repository.EmployeeRepository;
import com.exampleRestapi.leaveapp.security.JwtUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
//	public Employee saveEmployee(Employee employee) {
//		return repository.save(employee);
//	}
	
//	@PreAuthorize("hasRole('MANAGER')")
//	public List<Employee> getAllEmployees(){
//		return repository.findAll();
//	}
	
	public Employee updateEmployee(Long id, Employee newData) {
		Employee emp = repository.findById(id).orElse(null);
		
		if(emp!=null) {
			emp.setName(newData.getName());
			emp.setEmail(newData.getEmail());
			emp.setPassword(newData.getPassword());
			emp.setDepartment(newData.getDepartment());
			emp.setRole(newData.getRole());
			return repository.save(emp);
		}
		return null;
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}

	public Employee getEmployeeById(Long id) {
		return repository.findById(id)
				.orElseThrow( () -> 
				new ResourceNotFoundException("Employee not found") );
	}

    public Employee saveEmployee(Employee employee) {
	employee.setPassword(encoder.encode(employee.getPassword()));
	return repository.save(employee);
   }
    
    
	public String login(String email, String password) {
		Employee emp = repository.findByEmail(email).orElse(null);
		
		if(emp!= null && encoder.matches(password, emp.getPassword() ) ) {
			return JwtUtil.generateToken(emp.getEmail(),emp.getRole());
		}
		return "Invalid Creadentials";
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
}
