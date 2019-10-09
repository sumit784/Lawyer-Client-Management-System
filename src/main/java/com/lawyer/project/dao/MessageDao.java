package com.lawyer.project.dao;

import java.util.List;

import com.lawyer.project.models.Message;

public interface MessageDao {
	//void insertEmployee(Employee cus);
	//void insertEmployees(List<Employee> employees);
	Message getMessageById(String username);
	//Employee getEmployeeById(String empId);
}