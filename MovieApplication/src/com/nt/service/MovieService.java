package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.bo.RegistrationActorBo;
import com.nt.bo.RegistrationBo;
import com.nt.dao.MovieDao;
import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
@Service
public class MovieService {
	@Resource
	private MovieDao mdao;
/*
	public MovieDao getMdao() {
		return mdao;
	}

	public void setMdao(MovieDao mdao) {
		this.mdao = mdao;
	}
	*/

	public List<RegistrationDto> service() {
		List<RegistrationBo> listregbo=mdao.retrivemovie();
		List<RegistrationDto> listregdto=new ArrayList<RegistrationDto>();
		for(RegistrationBo bo:listregbo)
		{
			RegistrationDto regdto=new RegistrationDto();
			regdto.setMoviename(bo.getMoviename());
			regdto.setReleasedate(bo.getReleasedate());
			regdto.setActorname(bo.getActorname());
			regdto.setDescription(bo.getDescription());
			regdto.setBlob(bo.getBlob());
			
			listregdto.add(regdto);
		}
		return listregdto;
		
		
	}

    
	
}
