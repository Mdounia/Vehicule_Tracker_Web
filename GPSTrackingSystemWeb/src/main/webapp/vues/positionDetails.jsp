<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Detail de l'affectation</title>
</head>
<body>
<%@include file='index.jsp'%>
<div class="container">
	<form action="Position">
		<div class="mb-3">
			<label for="id" class="form-label">Id</label> <input type="text"
				name="id" value="${position.id}" readonly="readonly"
				class="form-control">
		</div>
		<div class="mb-3">
			<label for="longitude" class="form-label">Longitude</label> <input
				type="text" name="longitude" value="${position.longitude}"
				class="form-control" >
		</div>
		<div class="mb-3">
			<label for="latitude" class="form-label">Latitude</label> <input
				type="text" name="latitude" value="${position.latitude}"
				class="form-control" >
		</div>
		<div class="mb-3">
				<label for="date" class="form-label">Date debut</label> <input
					type="text" name="date" value="${position.date}" class="form-control" >
			</div>
			<div class="mb-3">
				<label for="gpsTracker" class="form-label">GPSTracker</label> <input
					type="text" name="gpsTracker" value="${position.gpsTracker.simNumber }" class="form-control" >
			</div>
		<input type="submit" name="action" value="Modification" class="btn btn-info" /> 
		<input type="submit" name="action" value="Annuler" class="btn btn-secondary" />
	</form>
</div>
</body>
</html>
