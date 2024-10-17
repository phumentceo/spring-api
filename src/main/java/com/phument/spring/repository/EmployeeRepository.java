package com.phument.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phument.spring.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
