package com.lawyer.project.services.impl;

import java.util.List;

import com.lawyer.project.dao.EmployeeDao;
import com.lawyer.project.services.EmployeeService;
import com.lawyer.project.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}


}