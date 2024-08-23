package com.employee.service;

import java.util.List;
import com.employee.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    
    // Additional methods
    List<EmployeeDTO> getEmployeesByName(String name);
    EmployeeDTO getEmployeeByEmail(String email);
    boolean doesEmployeeExistByEmail(String email);
    boolean doesEmployeeExistByNumber(Long phoneNumber);
}
