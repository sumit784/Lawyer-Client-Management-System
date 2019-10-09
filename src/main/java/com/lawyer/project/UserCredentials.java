package com.lawyer.project;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class UserCredentials
{
    @Id
    private long id;
    private String username;
    private String phone;
    private String email;
    private String address; 
    private String password;

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }

    public String getPassword(){
        return password;
    }

    public void setId(long id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }

}