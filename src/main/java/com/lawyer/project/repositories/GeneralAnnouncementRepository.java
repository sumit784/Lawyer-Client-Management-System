package com.lawyer.project.repositories;

import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.GeneralAnnouncements;
import com.lawyer.project.models.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralAnnouncementRepository extends CrudRepository<GeneralAnnouncements, Long> {

    List <GeneralAnnouncements> findAll();
    
    @Query(value="select password,user.name from user_credentials,user where password=\"username\" and user.id=1", nativeQuery=true)
    String getAnn();
    
    //@Query(value="insert into user_credentials values(\"venkat\",\"venkat\")", nativeQuery=true)
    //void putAnn();
    Optional<GeneralAnnouncements> findById(Long id);
    

}