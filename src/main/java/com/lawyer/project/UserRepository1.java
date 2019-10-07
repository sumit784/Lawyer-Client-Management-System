package com.lawyer.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository1 extends JpaRepository<UserCredentials, Long>{
    
    UserCredentials findByUsername(String username);
}