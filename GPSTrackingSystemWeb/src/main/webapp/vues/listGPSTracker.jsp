<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Liste des GPS tracker</title>
</head>
<body>
	<%@include file='index.jsp'%>
	<br>
	<div class="container">
		<a class="btn btn-primary" href="GPSTracker?action=create_GPSTracker">Ajouter un GPSTracker</a>

		<br>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Id</th>
				<th>SIM Number</th>
				<th>IMEI</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${trackers}" var="t">
				<tr>
					<td>${t.id }</td>
					<td>${t.simNumber }</td>
					<td>${t.imei }</td>
					<td><a class="btn btn-info"
						href="GPSTracker?action=details&id=${t.id}">Détails</a> <a
						class="btn btn-danger"
						href="GPSTracker?action=suppression&id=${t.id}">Suppression</a></td>
				</tr>
			</c:forEach>
		</table>
		<canvas id="myChart" style="width:100%;max-width:700px"></canvas>
	<h2>${nbrs }</h2>
	</div>
<script>
var simNums = [];
var nbrs = [];
<c:forEach items="${trackers}" var="t">
	simNums.push([ "<c:out value="${t.simNumber }" />"]);
 </c:forEach>
 <c:forEach items="${nbrs}" var="n">
	nbrs.push(parseInt("<c:out value="${n }" />"));
</c:forEach>
new Chart("myChart", {
  type: "bar",
  data: {
    labels: simNums,
    datasets: [{
      data: nbrs
    }]
  },
  options: {
    legend: {display: false},
    title: {
      display: true,
      text: "World Wine Production 2018"
    }
  }
});
</script>
</body>
</html>