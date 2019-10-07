package com.lawyer.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, max=255, message="Name should have atleast 1 letter and at max 255 letters!")
    private String name;

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
    public Users(){

    }

}