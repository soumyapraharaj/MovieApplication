<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navigationmenu.jsp"></jsp:include>
<form:form  method="post" enctype="multipart/form-data"  autocomplete="on">
<table>
<tr>
<th>MOVIE NAME</th>
<td><input type="text" name="moviename" value="${regmsg3.moviename}" readonly />
</tr>
<tr>
<th>DATE OF RELEASE</th>
<td><input type="text" name="releasedate"  value="${regmsg3.releasedate}"required/>
</tr>
<tr>
<th>DESCRIPTION</th>
<td><textarea name="description" rows="10" cols="20"  required>${regmsg3.description} </textarea>
</tr>
<tr>
<th>POSTER</th>
<td><input type="file" name="file1" value="${regmsg3.file1}" required/>
</tr>
<tr>
<th>ACTOR NAME</th>
<td><input type="text" name="actorname" value="${regmsg3.actorname}" required />
</tr>
<tr>
<td><input type="submit" value="editmovie" /></td>
</tr>
</table>
</form:form>
</body>
</html>