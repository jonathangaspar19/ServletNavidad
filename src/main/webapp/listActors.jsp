<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*,es.salesianos.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Actor</title>
</head>

<%
	List<Actor> actors = (List<Actor>) request.getAttribute("listAllActors");
	pageContext.setAttribute("actors", actors);
	if (actors!=null) {
		System.out.println("actors.size " + actors.size());	
	} else {
		System.out.println("actors " + actors);	
	}
%>

<body>
	<form action="addActor" method="post">
		<span>Name:</span><input type="text" name="name"> <span>Date
			Of Birth:</span><input type="text" name="dateOfBirth"> <input
			type="submit">
		<!-- button type="button">My button</button>-->
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Cod Actor</td>
				<td>Name</td>
				<td>Year of Birth</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor" items="${actors}">
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
</body>
</html>