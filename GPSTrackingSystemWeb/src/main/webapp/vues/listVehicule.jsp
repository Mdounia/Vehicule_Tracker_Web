<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Liste des vehicules</title>
</head>
<body>
	<%@include file='index.jsp'%>
	<br>
	<div class="container">
		<a class="btn btn-primary" href="Vehicule?action=create_Vehicule">Ajouter un vehicule</a>
		<br>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Matricule</th>
				<th>Marque</th>
				<th>Type</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${vehicules}" var="v">
				<tr>
					<td>${v.id }</td>
					<td>${v.matricule }</td>
					<td>${v.marque }</td>
					<td>${v.type }</td>
					<td><a class="btn btn-info"
						href="Vehicule?action=details&id=${v.id}">Détails</a> <a
						class="btn btn-danger"
						href="Vehicule?action=suppression&id=${v.id}">Suppression</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>