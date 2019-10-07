package com.lawyer.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name="general_annoucements")
public class GeneralAnnouncements {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    } 

    public String getText(){
        return this.text;
    }

    public void setText(String name){
        this.text = name;
    }
    public GeneralAnnouncements(){

    }
}
