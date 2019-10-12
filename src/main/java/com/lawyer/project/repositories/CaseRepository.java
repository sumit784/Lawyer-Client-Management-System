package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lawyer.project.UserCredentials;
import com.lawyer.project.models.Cases;
import com.lawyer.project.models.Document;

@Repository
public class CaseRepository{
    JdbcTemplate jdbctemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}


	public void addCase(String username,String case_type, Long court_id, Long judge_id, String description, Date judgement_date, Date previous_hearing_date, Date next_hearing_date, String status) {
		String sql="INSERT INTO cases(username, case_type,  court_id,  judge_id,  description,  judgement_date,  previous_hearing_date,  next_hearing_date,  status) values (:username, :case_type,  :court_id,  :judge_id,  :description,  :judgement_date,  :previous_hearing_date,  :next_hearing_date,  :status)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel( username, case_type,  court_id,  judge_id,  description,  judgement_date,  previous_hearing_date,  next_hearing_date,  status));
    }
    

    private SqlParameterSource getSqlParameterByModel(String username,String case_type, Long court_id, Long judge_id, String description, Date judgement_date, Date previous_hearing_date, Date next_hearing_date, String status)
    {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   paramSource.addValue("id", 0);
           paramSource.addValue("username", username);
           paramSource.addValue("case_type", case_type);
           paramSource.addValue("court_id", court_id);
           paramSource.addValue("judge_id", judge_id);
           paramSource.addValue("description", description);
           paramSource.addValue("judgement_date", judgement_date);
           paramSource.addValue("next_hearing_date", next_hearing_date);
           paramSource.addValue("previous_hearing_date", previous_hearing_date);
           paramSource.addValue("status", status);
	    return paramSource;
    }

    public List <Cases> getAllCases() {
        final String sql = "select * from cases";
        final List<Cases> rows = (List < Cases >) namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,null,null,null,null,null,null,null,null), new CaseMapper());
        return rows;
    }

    
    public List <Cases> getCasesByUsername(String username) {
        final String sql = "select * from cases where username=:username";
        final List<Cases> rows = (List < Cases >) namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(username,null,null,null,null,null,null,null,null), new CaseMapper());
        return rows;
    }

    public List <Cases> getCaseById(Long id) {
        final String sql = "select * from cases where id=:id";
        final List<Cases> rows = (List < Cases >) namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(id, null, null,null,null,null,null,null,null,null), new CaseMapper());
        return rows;
    }

    public void UpdateCaseBy(Cases cas) {
        final String sql = "update cases set username=:username, case_type=:case_type, court_id=:court_id, judge_id=:judge_id, description=:description, judgement_date=:judgement_date, previous_hearing_date=:previous_hearing_date, next_hearing_date=:next_hearing_date, status=:status where id=:id";
        int rows = namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cas.getId(), cas.getUsername(), cas.getCaseType(), cas.getCourt_id(), cas.getJudge_id(), cas.getDescription(), cas.getJudgementDate(), cas.getPreviousHearingDate(), cas.getNextHearingDate(), cas.getStatus()));
        System.out.println(rows);
    }

    private SqlParameterSource getSqlParameterByModel(Long id, String username,String case_type, Long court_id, Long judge_id, String description, Date judgement_date, Date previous_hearing_date, Date next_hearing_date, String status)
    {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   paramSource.addValue("id", id);
           paramSource.addValue("username", username);
           paramSource.addValue("case_type", case_type);
           paramSource.addValue("court_id", court_id);
           paramSource.addValue("judge_id", judge_id);
           paramSource.addValue("description", description);
           paramSource.addValue("judgement_date", judgement_date);
           paramSource.addValue("next_hearing_date", next_hearing_date);
           paramSource.addValue("previous_hearing_date", previous_hearing_date);
           paramSource.addValue("status", status);
	    return paramSource;
    }

    private static final class CaseMapper implements RowMapper<Cases>
   {
	   public Cases mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Cases user=new Cases();
		   user.setId(rs.getLong("id"));
           user.setUsername(rs.getString("username"));
           user.setCaseType(rs.getString("case_type"));
           user.setDescription(rs.getString("description"));
           user.setStatus(rs.getString("status"));
           user.setJudge_id(rs.getLong("judge_id"));
           user.setCourt_id(rs.getLong("court_id"));
           user.setJudgementDate(rs.getDate("judgement_date"));
           user.setPreviousHearingDate(rs.getDate("previous_hearing_date"));
           user.setNextHearingDate(rs.getDate("next_hearing_date"));
		   return user;
		   
	   }
   }


}
