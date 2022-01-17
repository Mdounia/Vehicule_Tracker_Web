<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Liste des affectations</title>
</head>
<body>
	<%@include file='index.jsp'%>
	<br>
	<div class="container">
		<a class="btn btn-primary" href="VehiculeGPSTracker?action=affecter">Affecter</a>
		<br>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Vehicule</th>
				<th>GPSTracker</th>
				<th>Date debut</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${affectations}" var="a">
				<tr>
					<td style="display:none;">${a.id.vehiculeId }</td>
					<td style="display:none;">${a.id.gpstrackerId }</td>
					<td>${a.vehicule.matricule }</td>
					<td>${a.gpstracker.simNumber }</td>
					<td>${a.dateDebut }</td>
					<td><a class="btn btn-info"
						href="VehiculeGPSTracker?action=details&vehiculeId=${a.id.vehiculeId }&gpstrackerId=${a.id.gpstrackerId}">Détails</a> <a
						class="btn btn-danger"
						href="VehiculeGPSTracker?action=suppression&vehiculeId=${a.id.vehiculeId }&gpstrackerId=${a.id.gpstrackerId}">Suppression</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>