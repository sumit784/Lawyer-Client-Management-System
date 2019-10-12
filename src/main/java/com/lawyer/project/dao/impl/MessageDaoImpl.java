package com.lawyer.project.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import com.lawyer.project.dao.MessageDao;
import com.lawyer.project.models.Message;

@Repository
public class MessageDaoImpl extends JdbcDaoSupport implements MessageDao{
	
	@Autowired 
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // @Override
    // public void insertEmployee(Employee emp) {
    // String sql = "INSERT INTO employee " +
    // "(empId, empName) VALUES (?, ?)" ;
    // getJdbcTemplate().update(sql, new Object[]{
    // emp.getEmpId(), emp.getEmpName()
    // });
    // }

    // @Override
    // public void insertEmployees(List<Employee> employees) {
    // String sql = "INSERT INTO employee " + "(empId, empName) VALUES (?, ?)";
    // getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
    // public void setValues(PreparedStatement ps, int i) throws SQLException {
    // Employee employee = employees.get(i);
    // ps.setString(1, employee.getEmpId());
    // ps.setString(2, employee.getEmpName());
    // }

    // public int getBatchSize() {
    // return employees.size();
    // }
    // });

    // }
    // @Override
    // public List<Employee> getAllEmployees(){
    // String sql = "SELECT * FROM employee";
    // List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

    // List<Employee> result = new ArrayList<Employee>();
    // for(Map<String, Object> row:rows){
    // Employee emp = new Employee();
    // emp.setEmpId((String)row.get("empId"));
    // emp.setEmpName((String)row.get("empName"));
    // result.add(emp);
    // }

    // return result;
    // }

    @Override
    public Message getMessageById(Long user) {
        final String sql = "select * from message where user=?";
        final List<Message> rows = (List < Message >) jdbcTemplate.query(sql, new Object[] { user }, new MessageMapper());
        return rows.get(0);
    }

    @Override
    public List<Message> getAllMessages() {
        final String sql = "select * from message";
        final List<Message> rows = (List < Message >) jdbcTemplate.query(sql, new Object[] {}, new MessageMapper());
        return rows;
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

   private static final class MessageMapper implements RowMapper<Message>
   {
	   public Message mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Message message=new Message();
		   message.setId(rs.getLong("id"));
		   message.setBody(rs.getString("body"));
		   message.setUser(rs.getLong("user"));
		   return message;
		   
	   }
   }

}