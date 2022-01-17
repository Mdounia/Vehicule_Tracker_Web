<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Ajouter un GPS tracker</title>
</head>
<body>
<%@include file='index.jsp'%>
	<div class="container">
		<form action="GPSTracker">
			<div class="mb-3">
				<label for="simNumber" class="form-label">SIM Number</label> <input
					type="text" name="simNumber" class="form-control">
			</div>
			<div class="mb-3">
				<label for="imei" class="form-label">IMEI</label> <input
					type="text" name="imei" class="form-control">
			</div>
			<input type="submit" name="action" value="Ajouter"
				class="btn btn-primary" />
		</form>
	</div>

</body>
</html>