<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<form action="VehiculeGPSTracker">
		<div class="mb-3">
			<input type="hidden" name="vehiculeId" value="${affectation.id.vehiculeId}">
		</div>
		<div class="mb-3">
			<input type="hidden" name="gpstrackerId" value="${affectation.id.gpstrackerId}" >
		</div>
		<div class="mb-3">
			<label for="vehicule" class="form-label">Vehicule</label> <input
				type="text" name="vehicule" value="${affectation.vehicule.matricule}"
				class="form-control" readonly="readonly">
		</div>
		<div class="mb-3">
			<label for="gpstracker" class="form-label">GPSTracker</label> <input
				type="text" name="gpstracker" value="${affectation.gpstracker.simNumber}"
				class="form-control" readonly="readonly">
		</div>
		<div class="mb-3">
				<label for="dateDebut" class="form-label">Date debut</label> <input
					type="date" name="dateDebut" value="<fmt:formatDate value="${affectation.dateDebut}" pattern="yyyy-MM-dd"/>" class="form-control" readonly="readonly">
			</div>
			<div class="mb-3">
				<label for="dateFin" class="form-label">Date fin</label> 
				<c:choose>
					<c:when test="${empty affectation.dateFin}">
       					 <input type="date" name="dateFin"class="form-control">
    				</c:when>
					<c:otherwise>
        				<input type="date" name="dateFin"class="form-control" value="<fmt:formatDate value="${affectation.dateFin}" pattern="yyyy-MM-dd"/>"  readonly="readonly">
    				</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
			    <c:when test="${empty affectation.dateFin}">
			        <input type="submit" name="action" value="Desaffectation" class="btn btn-info" /> 
			    </c:when>
			    <c:otherwise>
			        <input type="submit" name="action" value="Desaffectation" class="btn btn-info" disabled="disabled" /> 
			    </c:otherwise>
			</c:choose>
		<input type="submit" name="action" value="Annuler" class="btn btn-secondary" />
	</form>
</div>
</body>
</html>
