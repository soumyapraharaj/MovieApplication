package com.nt.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.RegistrationActorBo;
import com.nt.bo.RegistrationBo;
import com.nt.dto.RegistrationDto;
@Repository
public class MovieDao {
	private static final String GET_ALL_MOVIE="SELECT MOVIENAME,RELEASEDATE,DESCRIPTION,FILE1,ACTORNAME FROM MOVIE";
	@Autowired
	private JdbcTemplate jt;

	public List<RegistrationBo> retrivemovie() {
		// TODO Auto-generated method stub
		List<RegistrationBo> listregbo1=(List<RegistrationBo>)jt.query(GET_ALL_MOVIE, new MovieResultSetExtractor ());
		return listregbo1;
	}
	private class MovieResultSetExtractor implements ResultSetExtractor<List<RegistrationBo>>
	{
		    @Override
			public List<RegistrationBo> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<RegistrationBo> listregbo=new ArrayList<RegistrationBo>();
				while(rs.next())
				{
					RegistrationBo bo=new RegistrationBo();
					bo.setMoviename(rs.getString(1));
					bo.setReleasedate(rs.getDate(2));
					bo.setDescription(rs.getString(3));
					Blob blob= rs.getBlob(4);
					bo.setActorname(rs.getString(5));
	              bo.setBlob(blob);
	              //  bo.setBase64image(base64Image);
	                listregbo.add(bo);
	                
	            }    //while      
				
				return  listregbo;
			}//extract data
			}//class
	
}
