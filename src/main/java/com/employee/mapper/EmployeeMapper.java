package com.employee.mapper;

import com.employee.domain.Employee;
import com.employee.dto.EmployeeDTO;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }
        
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAddress(employeeDTO.getAddress());
        
        return employee;
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setAddress(employee.getAddress());
        
        return employeeDTO;
    }
}
