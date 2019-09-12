package com.nt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;  
import com.nt.command.RegisterActorCommand;
import com.nt.command.RegisterCommand;
import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
import com.nt.service.EditMovieService;
import com.nt.service.MovieService;
import com.nt.service.RegistrationService;
import com.nt.validator.MovieValidator;
@Controller
public class RegisterController {
@Resource
	private RegistrationService regservice;
@Resource
	private MovieService mserv;
@Resource
private EditMovieService editserv;
@Resource
private MovieValidator validator;

   /* public RegistrationService getRegservice() {
		return regservice;
	}


	public void setRegservice(RegistrationService regservice) {
		this.regservice = regservice;
	}

	public MovieService getMserv() {
		return mserv;
	}


	public void setMserv(MovieService mserv) {
		this.mserv = mserv;
	}*/

@RequestMapping(value="/addmovies.htm",method=RequestMethod.POST)
	public String addmovies(Model model,@Valid @ModelAttribute("regcmd") RegisterCommand command,BindingResult errors)
			throws Exception {
		// TODO Auto-generated method stub
		RegisterCommand cmd=null;
		String regmsg1=null;
		cmd=(RegisterCommand)command;
		 if(validator.supports(RegisterCommand.class))
		  {
			  validator.validate(cmd,errors);
			  if(errors.hasErrors())
			  {
				  return "movie";
			  }
		  }
		RegistrationDto dto=null;
		dto=new RegistrationDto();
		dto.setMoviename(cmd.getMoviename());
		dto.setReleasedate(cmd.getReleasedate());
		dto.setActorname(cmd.getActorname());
		dto.setFile1(cmd.getFile1());
		dto.setDescription(cmd.getDescription());
		dto.setActorname(cmd.getActorname());
		
	     try {
			regmsg1=regservice.register(dto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    List<RegistrationDto> listregdto= mserv.service();
	    model.addAttribute("regmsg",regmsg1);
	    model.addAttribute("movielist",listregdto);
		return "home";

	}

@RequestMapping(value="/addmovies.htm",method=RequestMethod.GET)
public String getactorlist(Model model) throws Exception {
	// TODO Auto-generated method stub
	List<RegisterActorDto> listregdto=regservice.getActor();
	//return new ModelAndView("movie","actorlist",listregdto);
	RegisterCommand regcmd=new RegisterCommand();
	model.addAttribute("regcmd",regcmd);
	model.addAttribute("actorlist",listregdto);
	return "movie";
}
@InitBinder
public void myInitBinder(WebDataBinder binder)
{
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
}
@ModelAttribute("actorlist")
public List<RegisterActorDto> populate(Model model)
{
	List<RegisterActorDto> listregdto=regservice.getActor();
	model.addAttribute("actorlist",listregdto);
	return listregdto;
}


}
