<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de inicio</title>
</head>
<body>
	<!-- <div>
		<a href="addActor.jsp">Show actors</a>
	</div> -->
	
	<form action="loadActorList" method="post">
		<input type="submit" value="Show Actors">
	</form>
	
	<form action="loadDirectorsList" method="post">
		<input type="submit" value="Show Directors">
	</form>	
	
	<!-- <div><a href="listFilms.jsp">Show Films</a></div>-->
	
	<form action="loadFilmList" method="post">
		<input type="submit" value="Show Films">
	</form>
	
	<div><a href="searchYear.jsp">Search Year of Birth</a></div>
	
	<!-- 
	<div>
		<a href="film/addFilm.jsp">Show Films</a>
	</div>
	
	<div>
		<a href="director/addDirector.jsp">Show Directors</a>
	</div>-->
	
</body>
</html>