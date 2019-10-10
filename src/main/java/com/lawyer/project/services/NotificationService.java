package com.lawyer.project.services;

import java.util.List;

import com.lawyer.project.UserCredentials;
import com.lawyer.project.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(UserCredentials user) throws MailException{
        //send email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("venkatshanmukha793@gmail.com");
        mail.setSubject("Welcome to the Lawyer Website");
        mail.setText("This is to inform you that your registration is successfully completed. \n\n"+"Your password.: "+user.getPassword()+ "\n"+"This message is confidential and subject to terms at https://localhost:8080 including on confidential, privileged or legal entity information.\n\n\nIf you are not the intended recipient, please delete this message and notify the sender immediately. Any unauthorized use is strictly prohibited.");
        javaMailSender.send(mail);
    }
    
    public void massMail(String mail, String body) throws MailException{
        //send email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(mail);
        email.setFrom("venkatshanmukha793@gmail.com");
        email.setSubject("Your Weekly Law Magazine");
        email.setText(body);
        javaMailSender.send(email);
    }
}