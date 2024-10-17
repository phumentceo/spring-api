package com.phument.spring.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.phument.spring.dto.EmployeeDto;
import com.phument.spring.exception.RecourseNotFoundException;
import com.phument.spring.mapper.EmployeeMapper;
import com.phument.spring.models.Employee;
import com.phument.spring.repository.EmployeeRepository;
import com.phument.spring.services.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

   
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee =  employeeRepository.findById(employeeId).orElseThrow( () -> 
           new RecourseNotFoundException("Employee is not exist with given id " +employeeId)
        );

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map( (employee) -> 
                EmployeeMapper.mapToEmployeeDto(employee)
        ).collect(Collectors.toList());

    }


    @Override
    public EmployeeDto updaEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee =  employeeRepository.findById(employeeId).orElseThrow( () -> 
           new RecourseNotFoundException("Employee is not exist with given id " + employeeId)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setLastName(employeeDto.getEmail());

        Employee updateEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow( () -> 
           new RecourseNotFoundException("Employee is not exist with given id " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
        
    }


    

    


    

}
