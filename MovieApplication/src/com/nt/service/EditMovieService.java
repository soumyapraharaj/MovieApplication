package com.nt.service;

import java.io.IOException;
import java.sql.Blob;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nt.bo.RegistrationBo;
import com.nt.dao.EditMovieDao;
import com.nt.dao.RegistrationDao;
import com.nt.dto.RegistrationDto;
@Service
public class EditMovieService {
	@Resource
	private EditMovieDao editdao;
	
	/*public EditMovieDao getEditdao() {
		return editdao;
	}

	public void setEditdao(EditMovieDao editdao) {
		this.editdao = editdao;
	}*/

	public String updateMovie(RegistrationDto dto) throws IOException
	{
		String s;
		RegistrationBo bo=new RegistrationBo();
		bo.setMoviename(dto.getMoviename());
		bo.setReleasedate(dto.getReleasedate());
		bo.setActorname(dto.getActorname());
		bo.setFile1(dto.getFile1());
		bo.setDescription(dto.getDescription());
	
		int i=editdao.registration(bo);
		if(i!=0)
		{
			s="movie updated sucessfully";
		}
		else
		{
			s=" movie not  sucessfully updated";
		}
		return s;
		
	}

	public RegistrationDto searchMovie(String moviename) {
		// TODO Auto-generated method stub
		RegistrationBo bo=editdao.getMovie(moviename);
		RegistrationDto dto=new RegistrationDto();
		dto.setMoviename(bo.getMoviename());
		dto.setReleasedate(bo.getReleasedate());
		dto.setActorname(bo.getActorname());
		dto.setDescription(bo.getDescription());
		dto.setFile1(bo.getFile1());
		return dto;
	}
	public Blob getPhoto(String id)
	{
		return editdao.getPhotoById(id);
		
	}
}
