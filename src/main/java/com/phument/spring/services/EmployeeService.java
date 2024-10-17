package com.phument.spring.services;

import java.util.List;

import com.phument.spring.dto.EmployeeDto;


public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updaEmployee(Long employeeId,EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);

}
