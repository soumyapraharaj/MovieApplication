package com.nt.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.RegisterActorCommand;
import com.nt.command.RegisterCommand;
import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
import com.nt.service.RegistrationService;
@Controller
public class AddActorController  {
	@Resource
     private RegistrationService regservice;
	
/*	public RegistrationService getRegservice() {
		return regservice;
	}

	public void setRegservice(RegistrationService regservice) {
		this.regservice = regservice;
	}*/

	@RequestMapping(value="/addactor.htm",method=RequestMethod.POST )
	public String addActor(Map<String,Object> map,@ModelAttribute RegisterActorCommand command) {
		RegisterActorCommand cmd=null;
		String actormsg1=null;
		cmd=(RegisterActorCommand)command;
	
		RegisterActorDto dto=null;
		dto=new RegisterActorDto();
		dto.setName(cmd.getName());
		dto.setSex(cmd.getSex());
		dto.setDob(cmd.getDob());
		dto.setBio(cmd.getBio());
	     actormsg1=regservice.registerActor(dto);
		map.put("actormsg",actormsg1);
		return "actor_result";
		
	}
	@RequestMapping(value="/addactor.htm",method=RequestMethod.GET )
	public String formActor(Model model)
	{
		RegisterActorCommand regActCmd=new RegisterActorCommand();
		model.addAttribute("userActCmd", regActCmd);
		return "add_actor";
	}


}