package com.lawyer.project.services;

import java.util.List;

import com.lawyer.project.models.*;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	List<Employee> getAllEmployees();
}