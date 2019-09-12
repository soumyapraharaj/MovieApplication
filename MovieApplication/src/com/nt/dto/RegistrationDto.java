package com.nt.dto;

import java.sql.Blob;
import java.util.Date;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public class RegistrationDto {
private String moviename;
private String actorname;
private Date releasedate;
private String description;
private MultipartFile file1;
private byte[] byteArray;
private String base64image;
private Blob blob;
public String getBase64image() {
	return base64image;
}
public void setBase64image(String base64image) {
	this.base64image = base64image;
}
public String getMoviename() {
	return moviename;
}
public void setMoviename(String moviename) {
	this.moviename = moviename;
}

public String getActorname() {
	return actorname;
}
public void setActorname(String actorname) {
	this.actorname = actorname;
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
public byte[] getByteArray() {
	return byteArray;
}
public void setByteArray(byte[] byteArray) {
	this.byteArray = byteArray;
}
public Blob getBlob() {
	return blob;
}
public void setBlob(Blob blob) {
	this.blob = blob;
}



}
