package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lawyer.project.UserCredentials;
import com.lawyer.project.models.Cases;
import com.lawyer.project.models.Document;
import com.lawyer.project.models.Judge;

@Repository
public interface JudgeRepository extends CrudRepository<Judge, Long> {

    //List <GeneralAnnouncements> findAll();
    
    @Query(value="select * from judge", nativeQuery=true)
    List<Judge> getAllJudges();

    // @Query(value="select text from general_annoucements", nativeQuery=true)
    // List <String> getAnnAll();
    
    //Optional<GeneralAnnouncements> findById(Long id);
    

}



