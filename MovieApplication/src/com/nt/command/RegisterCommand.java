package com.nt.command;

import java.sql.Blob;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class RegisterCommand {
private String moviename;
@NotNull
private String actorname;
//@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date releasedate;
private String description;
@NotNull
@NotEmpty
private MultipartFile file1;

private Blob blob;

public String getActorname() {
	return actorname;
}
public void setActorname(String actorname) {
	this.actorname = actorname;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}

public Date getReleasedate() {
	return releasedate;
}
public void setReleasedate(Date releasedate) {
	this.releasedate = releasedate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public MultipartFile getFile1() {
	return file1;
}
public void setFile1(MultipartFile file1) {
	this.file1 = file1;
}


}
