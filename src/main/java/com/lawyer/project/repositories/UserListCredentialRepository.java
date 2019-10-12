package com.lawyer.project.repositories;

import java.util.List;
import java.util.Optional;

import com.lawyer.project.UserCredentials;
import com.lawyer.project.models.GeneralAnnouncements;
//import com.lawyer.project.models.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public interface UserListCredentialRepository extends CrudRepository<UserCredentials, Long> {

    //List <GeneralAnnouncements> findAll();
    
    @Query(value="select username from user_credentials", nativeQuery=true)
    List<String> getAllUsers();
    
    //Optional<GeneralAnnouncements> findById(Long id);
    

}