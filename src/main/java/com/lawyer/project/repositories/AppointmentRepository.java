package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.lawyer.project.models.Appointment;
import com.lawyer.project.models.GeneralAnnouncements;
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
public class AppointmentRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}


	public void addAppointment(String name, String address, String reason, String email, String contact_number, Date appointment_date ) {
		String sql="INSERT INTO appointment(name,address,reason,email,contact_number,appointment_date) values (:name,:address,:reason,:email,:contact_number,:appointment_date)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(name,address,reason,email,contact_number,appointment_date));
    }
    
    private SqlParameterSource getSqlParameterByModel(String name, String address, String reason, String email, String contact_number, Date appointment_date)
    {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   paramSource.addValue("id", 0);
		   paramSource.addValue("name", name);
		   paramSource.addValue("address", address);
           paramSource.addValue("reason", reason);
           paramSource.addValue("email", email);
           paramSource.addValue("contact_number", contact_number);
           paramSource.addValue("appointment_date", appointment_date);
	    return paramSource;
    }

    public List<Appointment> getAllAppointments() {
        final String sql = "select * from appointment";
        final List<Appointment> rows = (List < Appointment >) jdbcTemplate.query(sql, new Object[] {}, new AppointmentMapper());
        return rows;
    }

    private static final class AppointmentMapper implements RowMapper<Appointment>
   {
	   public Appointment mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
        Appointment appointment=new Appointment();
            appointment.setId(rs.getLong("id"));
            appointment.setName(rs.getString("name"));
            appointment.setAddress(rs.getString("address"));
            appointment.setContactNumber(rs.getString("contact_number"));
            appointment.setReason(rs.getString("reason"));
            appointment.setAppointmentDate(rs.getDate("appointment_date"));
		   return appointment;
		   
	   }
   }


}