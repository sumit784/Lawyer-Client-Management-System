package com.lawyer.project.repositories;

import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.GeneralAnnouncements;
import com.lawyer.project.models.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAnnouncementRepository extends CrudRepository<GeneralAnnouncements, Long> {

    List <GeneralAnnouncements> findAll();
    
    @Query(value="select body from message where user=\"venkat\"", nativeQuery=true)
    String getAnn();
    
    //@Query(value="insert into user_credentials values(\"venkat\",\"venkat\")", nativeQuery=true)
    //void putAnn();
    Optional<GeneralAnnouncements> findById(Long id);
    

}