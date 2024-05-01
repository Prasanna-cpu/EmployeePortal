package com.EmployeePortal.EmployeePortal.Controller;


import com.EmployeePortal.EmployeePortal.Exceptions.EmptyDataException;
import com.EmployeePortal.EmployeePortal.Service.EmployeeService;
import com.EmployeePortal.EmployeePortal.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeByID(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() throws EmptyDataException {
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeByID(@PathVariable("id") Long id,EmployeeDto updatedEmployee){
        EmployeeDto updatedEmployeeDetails=employeeService.updateEmployee(id,updatedEmployee);
        return  ResponseEntity.ok(updatedEmployeeDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
