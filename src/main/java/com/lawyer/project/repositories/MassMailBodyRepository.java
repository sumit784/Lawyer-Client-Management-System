package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.Appointment;
import com.lawyer.project.models.GeneralAnnouncements;
import com.lawyer.project.models.MassMailBody;
import com.lawyer.project.models.Users;

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
public class MassMailBodyRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
    }
    public void addBody(MassMailBody massmail) {
        String sql="INSERT INTO massmailbody(body) values(:body)";
        namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(massmail));
    }

    private SqlParameterSource getSqlParameterByModel(MassMailBody massmail)
    {
        MapSqlParameterSource paramSource =new MapSqlParameterSource();
        paramSource.addValue("id", 0);
        paramSource.addValue("body", massmail.getBody());
        return paramSource;
    }







}