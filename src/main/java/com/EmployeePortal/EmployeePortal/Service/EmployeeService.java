package com.EmployeePortal.EmployeePortal.Service;

import com.EmployeePortal.EmployeePortal.Exceptions.EmptyDataException;
import com.EmployeePortal.EmployeePortal.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeService {


    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByID(Long employeeID);

    List<EmployeeDto> getAllEmployees() throws EmptyDataException;

    EmployeeDto updateEmployee(Long id,EmployeeDto updatedEmployee);

    void deleteEmployee(Long id);



}
