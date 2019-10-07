package com.lawyer.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
    private String name;
    @Id
    private long id;
    private String contactNumber;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    } 

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getContactNumber(){
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    } 

    public Employee(){

    }
 
    // standard getters and setters
}