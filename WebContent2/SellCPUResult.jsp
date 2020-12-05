<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="util2.SellUtil"%>
<%@ page import="datamodel2.*"%>
<% 
Integer userID = (Integer) session.getAttribute("userID");
String modelName = request.getParameter("modelName");
String cores = request.getParameter("cores");
String frequency = request.getParameter("frequency");
String socket = request.getParameter("socket");
String dataPoints = SellUtil.getCPUsSoldJSON(frequency, cores, socket);
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
		<form action="SellConfirmation.jsp" style="width: 800px; display: flex; flex-direction: column; align-items: center;">
			<div><label>Your Price: </label><input type="text" name="price"></div>
			<input type="hidden" name="type" value="CPU">
			<input type="hidden" name="modelName" value="<%=modelName %>">
			<input type="hidden" name="frequency" value="<%=frequency %>">
			<input type="hidden" name="cores" value="<%=cores %>">
			<input type="hidden" name="socket" value="<%=socket %>">
			<% if (userID != null) {%>
				<input type="submit" value="Sell">
			<%} else {%>
			<label>You must login first</label>
			<%} %>
		</form>
	</div>
</body>
</html>