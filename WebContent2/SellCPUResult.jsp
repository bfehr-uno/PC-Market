<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="util2.UtilDBPCMarket"%>
<%@ page import="datamodel2.*"%>
<%
String manufacturer = request.getParameter("manufacturer");
String model = request.getParameter("model");
String frequency = request.getParameter("frequency");
String cores = request.getParameter("cores");
String socket = request.getParameter("socket");
String dataPoints = UtilDBPCMarket.getCPUDataPoints(frequency, cores, socket);
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
			yValueFormatString: "$#,##0",
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
			<input type="hidden" name="type" value="CPU">
			<input type="hidden" name="manufacturer" value="<%=manufacturer %>">
			<input type="hidden" name="model" value="<%=model %>">
			<input type="hidden" name="frequency" value="<%=frequency %>">
			<input type="hidden" name="cores" value="<%=cores %>">
			<input type="hidden" name="socket" value="<%=socket %>">
			<input type="submit" value="Sell">
		</form>
	</div>
</body>
</html>