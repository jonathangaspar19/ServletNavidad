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
	List<Pelicula> listFilm = (List<Pelicula>) request.getAttribute("listAllPeliculas");
	pageContext.setAttribute("films", listFilm);
	if (listFilm!=null) {
		System.out.println("listFilm.size in the jsp: " + listFilm.size());	
	} else {
		System.out.println("listFilm in the jsp: " + listFilm);	
	}
		
%> --%>

<body>
	<form action="addFilm" method="post">
		<span>Tittle:</span><input type="text" name="tittle"> 
		<span>CodOwner:</span><input type="text" name="codOwner"> 
		<input type="submit">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Tittle</td>
				<td>Cod Owner</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="film" items="${listAllPeliculas}">
				<tr>
					<td><c:out value="${film.titulo}" /></td>
					<td><c:out value="${film.codDirector}" /></td>
					<%-- <td><a href="/editOwner?codOwner=${owner1.codOwner}">EDIT</a>
					</td> 
					<td><a href="/confirmDeleteOwner?cod=${actor.cod}">DELETE</a>
					</td>
					--%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>