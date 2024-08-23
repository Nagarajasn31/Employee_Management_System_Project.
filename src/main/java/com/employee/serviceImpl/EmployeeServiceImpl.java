package com.employee.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDAO;
import com.employee.domain.Employee;
import com.employee.dto.EmployeeDTO;
import com.employee.exception.ResourceNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if (employeeDAO.existsByEmail(employeeDTO.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }
        if (employeeDAO.existsByPhoneNumber(employeeDTO.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists.");
        }
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeDAO.saveEmployee(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }

        employee.setName(employeeDTO.getName());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAddress(employeeDTO.getAddress());

        Employee updatedEmployee = employeeDAO.updateEmployee(id, employee);  // Ensure this method signature matches the DAO
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
        employeeDAO.deleteEmployee(id);
        System.out.println("Employee deleted successfully...!!");
    }

    @Override
    public List<EmployeeDTO> getEmployeesByName(String name) {
        List<Employee> employees = employeeDAO.findByName(name);
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeByEmail(String email) {
        Employee employee = employeeDAO.findByEmail(email);
        if (employee == null) {
            throw new ResourceNotFoundException("Employee", "email", email);
        }
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public boolean doesEmployeeExistByEmail(String email) {
        return employeeDAO.existsByEmail(email);
    }

    @Override
    public boolean doesEmployeeExistByNumber(Long phoneNumber) {
        return employeeDAO.existsByPhoneNumber(phoneNumber);
    }
}
