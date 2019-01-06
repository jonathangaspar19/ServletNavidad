<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*,es.salesianos.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Director</title>
</head>

<%
	List<Director> directors = (List<Director>) request.getAttribute("listAllDirectores");
	pageContext.setAttribute("directors", directors);
	if (directors!=null) {
		System.out.println("directors.size " + directors.size());	
	} else {
		System.out.println("directors " + directors);	
	}
	
%>

<body>
	<form action="addDirector" method="post">
		<span>Name:</span><input type="text" name="name"> 
		<input type="submit">
		<!-- button type="button">My button</button>-->
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Cod Director</td>
				<td>Name</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="director" items="${directors}">
				<tr>
					<td><c:out value="${director.cod}" /></td>
					<td><c:out value="${director.name}" /></td>
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