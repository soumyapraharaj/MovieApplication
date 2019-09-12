<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}
td{
height:50px;
width:130px;
}
</style>
</head>
<body>
<jsp:include page="navigationmenu.jsp"></jsp:include>
<table>
<tr>
<th>movie name</th>
<th>year of release</th>
<th>plot</th>
<th>post</th>
<th>edit</th>
<th>actor name</th>
</tr>
<c:forEach var="movie" items="${movielist}">
<tr bgcolor="gray">
<td ><c:out value="${movie.moviename}"/></td>
<td><c:out value="${movie.releasedate}"/></td>
<td><c:out value="${movie.description}"/></td>
<td><img src="welcome1.htm?id=${movie.moviename}" alt="image" width="140" height="150"></td>

<td><a href="edit.htm?id=${movie.moviename}"><img src=" C:\Users\soumya praharaj\Desktop\edit.png" height="30" width="30"/></a></td>
<td><c:out value="${movie.actorname}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>
