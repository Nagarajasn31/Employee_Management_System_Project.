package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(Long phoneNumber);  
       
}




