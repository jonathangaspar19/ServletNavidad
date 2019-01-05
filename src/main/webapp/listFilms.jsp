<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*,es.salesianos.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film</title>
</head>

<%-- <%
	List<Pelicula> actors = (List<Pelicula>) request.getAttribute("listAllPeliculas");
	pageContext.setAttribute("films", listFilm);
%>
 --%>
<body>
	<form action="addActor" method="post">
		<span>Tittle:</span><input type="text" name="tittle"> <span>Cod
			Owner:</span><input type="text" name="codOwner"> <input
			type="submit">
		<!-- button type="button">My button</button>-->
	</form>
<!-- 
	<table border="1">
		<thead>
			<tr>
				<td>Cod Film</td>
				<td>Tittle</td>
				<td>Cod Owner</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="film" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor.cod}" /></td>
					<td><c:out value="${actor.name}" /></td>
					<td><c:out value="${actor.yearOfTheBirthDate}" /></td>
					<%-- <td><a href="/editOwner?codOwner=${owner1.codOwner}">EDIT</a>
					</td> --%>
					<td><a href="/confirmDeleteOwner?cod=${actor.cod}">DELETE</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	 -->
</body>
</html>