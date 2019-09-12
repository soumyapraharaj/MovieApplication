package com.nt.dao;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nt.bo.RegistrationBo;
@Repository
public class EditMovieDao {
	private static final String query="update movie set releasedate=?,description=?,file1=?,actorname=? where moviename=?";
	private static final String get_query="select moviename,releasedate,description,file1,ACTORNAME from movie where moviename=? ";

	String query1 = "select  file1 from Movie where moviename=?";
    @Autowired
	private JdbcTemplate jt;
	
	public int registration(RegistrationBo bo) throws IOException {
		// TODO Auto-generated method stub
	   int count=0;
	   MultipartFile mf=bo.getFile1();
	   byte[] photo=mf.getBytes();
	   	count=jt.update(query,bo.getReleasedate(),bo.getDescription(),photo,bo.getActorname(),bo.getMoviename());
		 return count;
	}


	public RegistrationBo getMovie(String moviename) {
		// TODO Auto-generated method stub
		System.out.println(moviename);
		RegistrationBo bo=jt.queryForObject(get_query,new MovieRowMapper(), moviename);
		return bo;
	}
	private class MovieRowMapper implements RowMapper<RegistrationBo>
	{

		@Override
		public RegistrationBo mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			RegistrationBo bo=new RegistrationBo();
			bo.setMoviename(rs.getString(1));
			bo.setReleasedate(rs.getDate(2));
			bo.setDescription(rs.getString(3));
		    bo.setActorname(rs.getString(5));
			return bo;
		}
		
	}

	public Blob getPhotoById(String id) {

	Blob photo = jt.queryForObject(query1, new Object[] { id }, Blob.class);

	return photo;
	}
	
}













