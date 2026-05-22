package com.exampleRestapi.leaveapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleRestapi.leaveapp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Optional<Employee> findByEmail(String email);
//	Employee findByEmail(String email);

}
