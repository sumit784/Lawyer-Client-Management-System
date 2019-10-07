package com.lawyer.project.dao;

import java.util.List;

import com.lawyer.project.models.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	List<Employee> getAllEmployees();
}