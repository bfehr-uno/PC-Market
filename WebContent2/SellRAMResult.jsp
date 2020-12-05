<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="util2.SellUtil"%>
<%@ page import="datamodel2.*"%>
<%
String model = request.getParameter("modelName");
String type = request.getParameter("type");
String capacity = request.getParameter("capacity");
String speed = request.getParameter("speed");
String dataPoints = SellUtil.getRAMsSoldJSON(type, capacity, speed);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script type="text/javascript">
	window.onload = function() { 
	 
	var chart = new CanvasJS.Chart("chart", {
		theme: "light2",
		title: {
			text: ""
		},
		axisX: {
			title: "Date"
		},
		axisY: {
			title: "Price ($)",
			includeZero: true
		},
		data: [{
			type: "line",
			yValueFormatString: "#,##0mn tonnes",
			dataPoints : <%out.print(dataPoints);%>
		}]
	});
	chart.render();
	 
	}
	</script>
</head>
<body>
	<jsp:include page="MenuBar.jsp" />
	<div class="chart-container" style="width: 100%; display: flex; justify-content: center;">
		<div id="chart" style="height: 370px; width: 800px;"></div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	</div>
	<div class="price" style="width: 100%; display: flex; justify-content: center;">
		<form action="SellConfirmation.jsp">
			<label>Your Price: </label><input type="text" name="price">
			<input type="hidden" name="type" value="RAM">
			<input type="hidden" name="modelName" value="<%=model %>">
			<input type="hidden" name="type" value="<%=type %>">
			<input type="hidden" name="capacity" value="<%=capacity %>">
			<input type="hidden" name="speed" value="<%=speed %>">
			<input type="submit" value="Sell">
		</form>
	</div>
</body>
</html>