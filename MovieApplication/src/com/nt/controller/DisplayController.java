package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.bo.RegistrationBo;
import com.nt.command.RegisterCommand;
import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
import com.nt.service.EditMovieService;
import com.nt.service.MovieService;
import com.nt.service.RegistrationService;
@Controller
public class DisplayController  {
    @Resource
	private EditMovieService editservice;
    @Resource
	private MovieService mserv;
    @Resource
    private RegistrationService regserv;
	
	/*public EditMovieService getEditservice() {
		return editservice;
	}


	public void setEditservice(EditMovieService editservice) {
		this.editservice = editservice;
	}*/
     @RequestMapping(value="/edit.htm",method=RequestMethod.GET)
	protected String display(Model model,@RequestParam("id") String id) throws Exception {
		// TODO Auto-generated method stub	
		 RegistrationDto regdto=editservice.searchMovie(id);
		 RegisterCommand regcmd=new RegisterCommand();
		 //return new ModelAndView("edit_movie","regmsg3",regdto);
		 model.addAttribute("regmsg3", regdto);
		 model.addAttribute("regcmd", regcmd);
		 return "edit_movie";
	}
     @RequestMapping(value="/edit.htm",method=RequestMethod.POST)
     public String editmovies(Model model,@ModelAttribute("regcmd") RegisterCommand command,BindingResult errrors)
     {
    	 RegisterCommand cmd=null;
 		String editmsg1=null;
 		cmd=(RegisterCommand)command;
 		RegistrationDto dto=null;
 		dto=new RegistrationDto();
 		dto.setMoviename(cmd.getMoviename());
 		dto.setReleasedate(cmd.getReleasedate());
 		dto.setActorname(cmd.getActorname());
 		dto.setDescription(cmd.getDescription());
 		dto.setFile1(cmd.getFile1());
 		
 		    	 try {
 		 			editmsg1=editservice.updateMovie(dto);
 		 		} catch (IOException e) {
 		 			// TODO Auto-generated catch block
 		 			e.printStackTrace();
 		 		}
 		       
 	    List<RegistrationDto> listregdto1=mserv.service();
 		model.addAttribute("editmsg",editmsg1);
 		model.addAttribute("movielist",listregdto1);
 		return "home";
 	
     }

}
/*boolean b=false;
 List<RegisterActorDto>  listregdto=regserv.getActor();

	 String actorname=cmd.getActorname();
	 String[] s1=actorname.split(",");
   for(String s2:s1)
		{
	 for(RegisterActorDto regdto:listregdto)
	     {
	    	 String s=regdto.getName();
	    	
	   if(s2.equals(s))
	   {	   
			b=true;
			continue;
		}
	}//for
	 if(b==false)
	 {
		 
	 }
	*/
