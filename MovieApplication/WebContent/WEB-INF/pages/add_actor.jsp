<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navigationmenu.jsp"></jsp:include>
<form:form method="post" commandName="regActcmd">
<table>
<tr>
<th>ACTOR NAME</th>
<td><input type="text" name="name" required/></td>
</tr>
<tr>
<th>SEX</th>
<td><input type="radio" name="sex" value="male"/>male
<input type="radio" name="sex" value="female"/>female
<input type="radio" name="sex" value="others"/>others</td>
</tr>
<tr>
<th>Date OF Birth</th>
<td><input type="date" name="dob" required/></td>
</tr>
<tr>
<th>Bio</th>
<td><textarea rows="8" cols="30" name="bio" required></textarea></td>
</tr>
<tr>
<td><input type="submit" value="save"/>
<input type="submit" value="cancel"/></td>
</tr>
</table>

</form:form>
</body>
</html>