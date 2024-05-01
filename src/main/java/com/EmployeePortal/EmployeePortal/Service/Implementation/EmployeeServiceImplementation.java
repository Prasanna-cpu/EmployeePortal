package com.EmployeePortal.EmployeePortal.Service.Implementation;

import com.EmployeePortal.EmployeePortal.Entity.Employee;
import com.EmployeePortal.EmployeePortal.Exceptions.EmptyDataException;
import com.EmployeePortal.EmployeePortal.Exceptions.ResourceNotFoundException;
import com.EmployeePortal.EmployeePortal.Mapper.EmployeeMapper;
import com.EmployeePortal.EmployeePortal.Repository.EmployeeRepository;
import com.EmployeePortal.EmployeePortal.Service.EmployeeService;
import com.EmployeePortal.EmployeePortal.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeID){
        Employee employee=employeeRepository.findById(employeeID).orElseThrow(()->new ResourceNotFoundException("Sorry!, the given employee id does not exist"+employeeID));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() throws EmptyDataException {
        List<Employee> listEmployees=employeeRepository.findAll();
        if(listEmployees.isEmpty()){
            throw new EmptyDataException("It is empty here , add some users");
        }
        return listEmployees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id:"+id));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));

    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id:"+id));
        employeeRepository.deleteById(id);

    }


}
