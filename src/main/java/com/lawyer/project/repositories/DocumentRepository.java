package com.lawyer.project.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.lawyer.project.models.Document;

@Repository
public class DocumentRepository{
    JdbcTemplate jdbctemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}


	public void addDocument(String filename, String username) {
		String sql="INSERT INTO documents(username,filename) values (:username,:filename)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(filename,username));
    }
    
    private SqlParameterSource getSqlParameterByModel(String filename, String username)
    {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   paramSource.addValue("id", 0);
		   paramSource.addValue("username", username);
		   paramSource.addValue("filename", filename);
	    return paramSource;
    }

    private SqlParameterSource getSqlParameterByModel(String username)
    {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   paramSource.addValue("id", 0);
		   paramSource.addValue("username", username);
		   paramSource.addValue("filename", "");
	    return paramSource;
    }

    public List<Document> getAllDocuments() {
        final String sql = "select * from documents";
        final List<Document> rows = (List < Document >) jdbctemplate.query(sql, new Object[] {}, new DocumentMapper());
        return rows;
    }

    
    public List <Document> getDocumentByUsername(String username) {
        final String sql = "select * from documents where username=:username";
        final List<Document> rows = (List < Document >) namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(username), new DocumentMapper());
        return rows;
    }

    private static final class DocumentMapper implements RowMapper<Document>
   {
	   public Document mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Document user=new Document();
		   user.setId(rs.getLong("id"));
           user.setUsername(rs.getString("username"));
           user.setFilename(rs.getString("filename"));
		   return user;
		   
	   }
   }


}
