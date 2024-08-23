package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.exception.ResourceNotFoundException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeDTO savedEmployee = employeeService.saveEmployee(employeeDTO);
            response.put("data", savedEmployee);
            response.put("message", "Employee saved successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("error", "Failed to create employee: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<Map<String, Object>> getAllEmployees() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<EmployeeDTO> employees = employeeService.getAllEmployees();
            response.put("data", employees);
            response.put("message", "Employees retrieved successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve employees: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getById/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeDTO employee = employeeService.getEmployeeById(id);
            response.put("data", employee);
            response.put("message", "Employee retrieved by ID");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Employee not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve employee: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
            response.put("data", updatedEmployee);
            response.put("message", "Employee updated successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Employee not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to update employee: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteById/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            employeeService.deleteEmployee(id);
            response.put("message", "Employee deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Employee not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to delete employee: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getByName/{name}")
    public ResponseEntity<Map<String, Object>> getEmployeesByName(@PathVariable("name") String name) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<EmployeeDTO> employees = employeeService.getEmployeesByName(name);
            response.put("data", employees);
            response.put("message", "Employees retrieved by name");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve employees by name: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getByEmail/{email}")
    public ResponseEntity<Map<String, Object>> getEmployeeByEmail(@PathVariable("email") String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            EmployeeDTO employee = employeeService.getEmployeeByEmail(email);
            response.put("data", employee);
            response.put("message", "Employee retrieved by email");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            response.put("error", "Employee not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.put("error", "Failed to retrieve employee by email: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/existsByEmail/{email}")
    public ResponseEntity<Map<String, Object>> doesEmployeeExistByEmail(@PathVariable("email") String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean exists = employeeService.doesEmployeeExistByEmail(email);
            response.put("data", exists);
            response.put("message", "Employee existence status by email retrieved");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to check employee existence by email: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/existsByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Map<String, Object>> doesEmployeeExistByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean exists = employeeService.doesEmployeeExistByNumber(phoneNumber);
            response.put("data", exists);
            response.put("message", "Employee existence status by phone number retrieved");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("error", "Failed to check employee existence by phone number: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
