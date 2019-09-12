package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.RegisterCommand;
@Component
public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(RegisterCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("------------------------------");
		RegisterCommand cmd=(RegisterCommand)command;
		if(cmd.getMoviename()==null ||cmd.getMoviename().equals(" ") || cmd.getMoviename().length()==0)
		{
			errors.rejectValue("moviename","moviename.required");
		}
		if(cmd.getReleasedate()==null || cmd.getReleasedate().equals(" "))
		{
			errors.rejectValue("releasedate", "releasedate.required");
		}
		if(cmd.getDescription()==null || cmd.getDescription().equals(" ") || cmd.getDescription().length()==0)
		{
			errors.rejectValue("description", "description.required");
		}
		
	}

}
