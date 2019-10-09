package com.lawyer.project.services;

import java.util.List;

import com.lawyer.project.models.Message;

public interface MessageService {
	//void insertMessage(Message message);
	//void insertMessages(List<Message> messages);
	//void getAllMessages();
	Message  getMessagesForUser(String username);
	List <Message> getAllMessages();
}