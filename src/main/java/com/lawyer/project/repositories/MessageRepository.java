package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.Appointment;
import com.lawyer.project.models.GeneralAnnouncements;
import com.lawyer.project.models.MassMailBody;
//import com.lawyer.project.models.Users;
import com.lawyer.project.models.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
    }
    public void addMessage(Message message) {
        String sql="INSERT INTO message(body, user) values(:body,:user)";
        namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(message));
    }

    private static SqlParameterSource getSqlParameterByModel(Message message)
    {
	    MapSqlParameterSource paramSource =new MapSqlParameterSource();
	    if(message!= null)
	    {
		    paramSource.addValue("id", message.getId());
		    paramSource.addValue("body", message.getBody());
		    paramSource.addValue("user", message.getUser());  
	    }
	    return paramSource;
    }







}