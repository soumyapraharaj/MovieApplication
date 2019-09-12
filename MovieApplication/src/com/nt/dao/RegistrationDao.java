package com.nt.dao;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nt.bo.RegistrationActorBo;
import com.nt.bo.RegistrationBo;

@Repository
public class RegistrationDao {
	private static final String query="insert into Movie values(?,?,?,?,?)";
	private static final String actor_query="insert into actors values(?,?,?,?)";
	private static final String get_query="select name,sex,dob,bio from actors";
	@Autowired
	private JdbcTemplate jt;

	public int registration(RegistrationBo bo) throws IOException {
		// TODO Auto-generated method stub
	   int count=0;
	   MultipartFile mf=bo.getFile1();
	   byte[] photo=mf.getBytes();
	   	count=jt.update(query,bo.getMoviename(),bo.getReleasedate(),bo.getDescription(),photo,bo.getActorname());
		 return count;
	}


	public int registrationActor(RegistrationActorBo bo) {
		// TODO Auto-generated method stub
		int count=jt.update(actor_query,bo.getName(),bo.getSex(),bo.getDob(),bo.getBio());
		return count;
	}


	public List<RegistrationActorBo> actorList() {
		// TODO Auto-generated method stub
		List<RegistrationActorBo> listregbo=jt.query(get_query, new ActorResultSetExtractor());
		return listregbo;
	}
	private class ActorResultSetExtractor implements ResultSetExtractor<List<RegistrationActorBo>>
	{

		@Override
		public List<RegistrationActorBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			List<RegistrationActorBo> listregbo1=new ArrayList<RegistrationActorBo>();
			while(rs.next())
			{
				RegistrationActorBo bo=new RegistrationActorBo();
				bo.setName(rs.getString(1));
				bo.setSex(rs.getString(2));
				bo.setDob(rs.getDate(3));
				bo.setBio(rs.getString(4));
				 listregbo1.add(bo);
				
			}//while
			return  listregbo1;

		}// extractdata method
		
	}// class

	}
