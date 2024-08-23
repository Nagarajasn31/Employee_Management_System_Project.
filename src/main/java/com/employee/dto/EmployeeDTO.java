package com.employee.dto;

public class EmployeeDTO {

	private Long id;
	private String name;
	private Long phoneNumber;
	private String email;
	private String designation;
	private double salary;
	private String address;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Long id, String name, Long phoneNumber, String email, String designation, double salary, String address) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
	}

	// Getters and Setters
	public Long getId() { 
		return id;
	}
	public void setId(Long id) {
		this.id = id; 
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber; 
	}
	public String getEmail() { 
		return email;
	}
	public void setEmail(String email) { 
		this.email = email; 
	}
	public String getDesignation() { 
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation; 
	}
	public double getSalary() { 
		return salary; 
	}
	public void setSalary(double salary) { 
		this.salary = salary; 
	}
	public String getAddress() { 
		return address; 
	}
	public void setAddress(String address) { 
		this.address = address;
	}
}
