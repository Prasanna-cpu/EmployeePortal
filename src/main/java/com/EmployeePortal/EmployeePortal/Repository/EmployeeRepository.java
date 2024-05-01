package com.EmployeePortal.EmployeePortal.Repository;

import com.EmployeePortal.EmployeePortal.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public static void main(String[] args) {

    }
}
