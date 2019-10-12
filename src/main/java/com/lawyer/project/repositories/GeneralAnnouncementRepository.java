package com.lawyer.project.repositories;

import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.GeneralAnnouncements;
//import com.lawyer.project.models.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAnnouncementRepository extends CrudRepository<GeneralAnnouncements, Long> {

    //List <GeneralAnnouncements> findAll();
    
    @Query(value="select text from general_annoucements order by id desc limit 1", nativeQuery=true)
    String getAnn();

    @Query(value="select text from general_annoucements", nativeQuery=true)
    List <String> getAnnAll();
    
    //Optional<GeneralAnnouncements> findById(Long id);
    

}