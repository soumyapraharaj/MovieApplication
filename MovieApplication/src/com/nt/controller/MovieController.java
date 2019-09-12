package com.nt.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.RegisterActorDto;
import com.nt.dto.RegistrationDto;
import com.nt.service.EditMovieService;
import com.nt.service.MovieService;
import com.nt.service.RegistrationService;
@Controller
public class MovieController {
	@Resource
      private MovieService mserv;
      @Resource 
      private RegistrationService regserv;
      @Resource
      private EditMovieService editserv;
      
	/*public MovieService getMserv() {
		return mserv;
	}


	public void setMserv(MovieService mserv) {
		this.mserv = mserv;
	}*/

@RequestMapping(value="/welcome.htm")
	public String getMovies(Model model) throws Exception {
		// TODO Auto-generated method stub
		List<RegistrationDto> listregdto=mserv.service();
	    model.addAttribute("movielist",listregdto);
		//return  new ModelAndView("home","movielist",listregdto);
		return "home";
	}
	
@RequestMapping(value = "/welcome1.htm")
public void getStudentPhoto(HttpServletResponse response, @RequestParam("id")String id) throws Exception {
	response.setContentType("image/jpeg");
	System.out.println("--------------------------");
	Blob ph = editserv.getPhoto(id);
	
	byte[] bytes = ph.getBytes(1, (int) ph.length());
	InputStream inputStream = new ByteArrayInputStream(bytes);
	IOUtils.copy(inputStream, response.getOutputStream());
}
}





