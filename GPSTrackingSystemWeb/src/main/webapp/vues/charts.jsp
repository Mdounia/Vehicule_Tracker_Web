<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<canvas id="myChart" style="width:100%;max-width:700px"></canvas>
<script>
var simNums = [];
var nbrs = [];
<c:forEach items="${simNum}" var="s">
	simNums.push([ "<c:out value="${ s }" />"]);
 </c:forEach>
 <c:forEach items="${nbrs}" var="n">
	nbrs.push([ "<c:out value="${ n }" />"]);
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