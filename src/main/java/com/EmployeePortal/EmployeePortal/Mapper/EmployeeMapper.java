package com.EmployeePortal.EmployeePortal.Mapper;

import com.EmployeePortal.EmployeePortal.Entity.Employee;
import com.EmployeePortal.EmployeePortal.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }


    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
