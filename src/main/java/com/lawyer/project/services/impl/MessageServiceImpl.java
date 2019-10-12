package com.lawyer.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.lawyer.project.dao.EmployeeDao;
import com.lawyer.project.dao.MessageDao;
import com.lawyer.project.models.Message;
import com.lawyer.project.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;

	// @Override
	// public void insertEmployee(Employee employee) {
	// 	employeeDao.insertEmployee(employee);
	// }

	// @Override
	// public void insertEmployees(List<Employee> employees) {
	// 	employeeDao.insertEmployees(employees);
	// }

	// public void getAllEmployees() {
	// 	List<Employee> employees = employeeDao.getAllEmployees();
	// 	for (Employee employee : employees) {
	// 		System.out.println(employee.toString());
	// 	}
	// }

	@Override
	public Message getMessagesForUser(Long user_id) {
		Message message_list = messageDao.getMessageById(user_id);
        return message_list;
	}

	@Override
	public List <Message> getAllMessages() {
		List <Message> message_list = messageDao.getAllMessages();
        return message_list;
	}

}