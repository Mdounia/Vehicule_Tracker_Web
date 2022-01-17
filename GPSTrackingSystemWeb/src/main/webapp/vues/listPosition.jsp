<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Liste des positions</title>
<style type="text/css">
      #map {
  height: 800px;
  width: 100%;
}
    </style>
</head>
<body>
	<%@include file='index.jsp'%>
	<br>
	<div class="container">
		<a class="btn btn-primary" href="Position?action=create_Position">Ajouter</a>
		<br>
		<br>
		<table class="table table-striped">
			<tr>
				<th>Longitude</th>
				<th>Latitude</th>
				<th>Date</th>
				<th>GPS Tracker</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${positions}" var="p">
				<tr>
					<td>${p.longitude }</td>
					<td>${p.latitude}</td>
					<td>${p.date }</td>
					<td>${p.gpsTracker.simNumber }</td>
					<td><a class="btn btn-info"
						href="Position?action=details&id=${p.id }">Détails</a> <a
						class="btn btn-danger"
						href="Position?action=suppression&id=${p.id}">Suppression</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
			<button id="action" onclick="initialize()"class="btn btn-primary">Recherche</button>
			<div id="map"></div>
		</fieldset>
	</div>
	<script type="text/javascript">

  var action=document.getElementById('action').value;
  var date1=document.getElementById("date1").value;
  var date2=document.getElementById("date2").value;
  function initialize() {
	  var map = new google.maps.Map(document.getElementById("map"), {
	    zoom: 4,
	    center: { lat: 31, lng: -8 },
	  });
	  // Set LatLng and title text for the markers. The first marker (Boynton Pass)
	  // receives the initial focus when tab is pressed. Use arrow keys to
	  // move between markers; press tab again to cycle through the map controls.
	  var tourStops = [];
      <c:forEach items="${positions}" var="p">
     // if( <fmt:formatDate value="${p.date}" pattern="yyyy-MM-dd"/> >= date1 && <fmt:formatDate value="${p.date}" pattern="yyyy-MM-dd"/> <= date2){
    	  tourStops.push([ "${p.latitude}",
              "${p.longitude}",
              "${p.id}"]);
    // }
      </c:forEach>
      var marker, i;
      
      for (i = 0; i < tourStops.length; i++) {  
        marker = new google.maps.Marker({
          position: new google.maps.LatLng(tourStops[i][0], tourStops[i][1]),
          map: map
        });


	}
  }
</script>
    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDco7uKTy5X8yuzINjb9GOd2rHb4Lwr24&libraries=&v=weekly"
      async
    ></script>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</body>
</html>