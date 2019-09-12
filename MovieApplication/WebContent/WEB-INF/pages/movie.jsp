<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navigationmenu.jsp"></jsp:include>
<form:form method="post"  enctype="multipart/form-data" action="addmovies.htm" commandName="regcmd" autocomplete="on">
<table>
<tr> 
<th> MOVIE NAME: </th>
<td> <form:input path="moviename" /> <form:errors path="moviename"/></td>
<tr>
<tr> 
<th> YEAR OF RELEASE: </th>
<td> <form:input path="releasedate" value="dd-MMM-yyyy" /><form:errors path="releasedate"/> </td>
</tr>
<tr>
<th> PLOT: </th>
<td> <textarea name="description" rows="3" cols ="30" ></textarea><form:errors path="description"></form:errors></td>
</tr>
<tr>
<th> POSTER: </th>
<td> <input type="file" name="file1" /> <form:errors path="file1"/></td>
</tr>
<tr>
<th>CAST</th>
<td>
<select name="actorname" size="3" multiple >
<c:forEach var="actor" items="${actorlist}">
<option><c:out value="${actor.name}" />
</option>
 </c:forEach>
 <form:errors path="actorname"/>
</select>
<input type="submit" value="actor" formaction="addactor.htm" formtarget="_blank" formmethod="get"/>
</td>
</tr>
<tr>
<td>
<input type="submit" value="save" />
<input type="submit" value="cancel" />
</td>
</tr>
</table>
</form:form>
</body>
</html>