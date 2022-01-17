<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Ajouter une position</title>
</head>
<body>
<%@include file='index.jsp'%>
	<div class="container">
		<form action="Position">
			<div class="mb-3">
				<label for="longitude" class="form-label">Longitude</label> <input
					type="number" name="longitude" class="form-control">
			</div>
			<div class="mb-3">
				<label for="latitude" class="form-label">Latitude</label> <input
					type="number" name="latitude" class="form-control">
			</div>
			<div class="mb-3">
				<label for="date" class="form-label">Date</label> <input
					type="date" name="date" class="form-control">
			</div>
			<div class="mb-3">
				<label for="GPSId" class="form-label">GPSTracker</label>
				 <select name="GPSId" class="form-control">
					<c:forEach items="${gpsTrackers }" var="g">
						<option value="${ g.id}">${g.simNumber }</option>
					</c:forEach>
				</select><br>
			</div>
			<input type="submit" name="action" value="Ajouter"
				class="btn btn-primary" />
		</form>
	</div>

</body>
</html>