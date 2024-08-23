package com.employee.dao;

import java.util.List;
import com.employee.domain.Employee;

public interface EmployeeDAO {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    
    // Additional methods
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(Long phoneNumber); 
    
    
    
    
    
}
