<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Detail d'un vehicule</title>
</head>
<body>
<%@include file='index.jsp'%>
<div class="container">
	<form action="Vehicule">
		<div class="mb-3">
			<label for="id" class="form-label">Id</label> <input type="text"
				name="id" value="${vehicule.id}" readonly="readonly"
				class="form-control">
		</div>
		<div class="mb-3">
			<label for="matricule" class="form-label">Matricule</label> <input
				type="text" name="matricule" value="${vehicule.matricule}"
				class="form-control">
		</div>
		<div class="mb-3">
			<label for="marque" class="form-label">Marque</label> <input
				type="text" name="marque" value="${vehicule.marque}"
				class="form-control">
		</div>
		<div class="mb-3">
			<label for="type" class="form-label">Type</label> <input type="text"
				name="type" value="${vehicule.type}" class="form-control">
		</div>
		<input type="submit" name="action" value="Modification" class="btn btn-info" /> 
		<input type="submit" name="action" value="Annuler" class="btn btn-secondary" />
	</form>
</div>
</body>
</html>
