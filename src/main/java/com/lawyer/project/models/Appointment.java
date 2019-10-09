package com.lawyer.project.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="appointment")
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String email;
    private String reason;
    @Temporal(TemporalType.DATE)
    Date appointmentDate;
    private String contactNumber;


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    } 

    public Date getAppointmentDate(){
        return appointmentDate;
    }

    public void setAppointmentDate(Date date){
        this.appointmentDate = date;
    } 

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getReason(){
        return this.reason;
    }

    public void setReason(String reason){
        this.reason = reason;
    }

    public String getContactNumber(){
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    } 

    public void setAddress(String address){
        this.address=address;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }

    public Appointment(){

    }
}
    