package com.nt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.bo.RegistrationActorBo;
import com.nt.bo.RegistrationBo;

import com.nt.dao.RegistrationDao;
import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
@Service
public class RegistrationService {
	@Resource
	private RegistrationDao regdao;

	/*public RegistrationDao getRegdao() {
		return regdao;
	}

	public void setRegdao(RegistrationDao regdao) {
		this.regdao = regdao;
	}*/
	
	public String register(RegistrationDto dto) throws IOException
	{
		String s;
		RegistrationBo bo=new RegistrationBo();
		bo.setMoviename(dto.getMoviename());
		bo.setReleasedate(dto.getReleasedate());
		bo.setFile1(dto.getFile1());
		bo.setDescription(dto.getDescription());
		bo.setActorname(dto.getActorname());
		int i=regdao.registration(bo);
		if(i!=0)
		{
			s="movie added sucessfully";
		}
		else
		{
			s=" movie not  sucessfully added";
		}
		return s;
		
	}

	public String registerActor(RegisterActorDto dto) {
		// TODO Auto-generated method stub
		String s;
		RegistrationActorBo bo=new RegistrationActorBo();
		bo.setName(dto.getName());
		bo.setSex(dto.getSex());
		bo.setDob(dto.getDob());
		bo.setBio(dto.getBio());
		int i=regdao.registrationActor(bo);
		if(i!=0)
		{
			s="actor added sucessfully";
		}
		else
		{
			s="actor not  sucessfully added";
		}
		return s;
	}

	public List<RegisterActorDto> getActor() {
		// TODO Auto-generated method stub
		List<RegistrationActorBo> listregbo=regdao.actorList();
		List<RegisterActorDto> listregdto=new ArrayList<RegisterActorDto>();
		for(RegistrationActorBo regbo:listregbo)
		{
			RegisterActorDto regdto=new RegisterActorDto();
			regdto.setName(regbo.getName());
			regdto.setSex(regbo.getSex());
			regdto.setDob(regbo.getDob());
			regdto.setBio(regbo.getBio());
			listregdto.add(regdto);
		}
		return listregdto;
	}

}
