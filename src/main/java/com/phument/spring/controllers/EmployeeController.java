package com.phument.spring.controllers;
import java.util.List;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.phument.spring.dto.EmployeeDto;
import com.phument.spring.services.EmployeeService;
import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build createing employees REST API 
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee  = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }


    // Build getting employee by id REST API 
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build getting all employees REST API 
    @GetMapping 
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.ok(allEmployees);
    }

    // Build updating employee REST API 
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updaEmployeeDto){
        EmployeeDto employeeDto =   employeeService.updaEmployee(employeeId, updaEmployeeDto);

        return ResponseEntity.ok(employeeDto); 
    }

    // Build deleting employee REST API 
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");  
        // HTTP Status 200 OK
    }
    
    
     
    
  
    

    
    
     

}
