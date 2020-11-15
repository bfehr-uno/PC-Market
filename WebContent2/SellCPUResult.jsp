<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%
			Gson gsonObj = new Gson();
			Map<Object,Object> map = null;
			List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
			 
			map = new HashMap<Object,Object>(); map.put("label", "FY07"); map.put("y", 188); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY08"); map.put("y", 213); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY09"); map.put("y", 213); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY10"); map.put("y", 219); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY11"); map.put("y", 207); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY12"); map.put("y", 167); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY13"); map.put("y", 136); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY14"); map.put("y", 152); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY15"); map.put("y", 129); list.add(map);
			map = new HashMap<Object,Object>(); map.put("label", "FY16"); map.put("y", 155); list.add(map);
			 
			String dataPoints = gsonObj.toJson(list);
			%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="SellResult.css">
	<script type="text/javascript">
		window.onload = function() { 
		 
		var chart = new CanvasJS.Chart("chartContainer", {
			theme: "light2",
			title: {
				text: ""
			},
			axisX: {
				title: ""
			},
			axisY: {
				title: "Production ( in million tonnes )",
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
	<div class="container">
		<div class="graph">
		</div>
		<div class="price">
			<form>
				<label>Your Price: </label><input type="text" name="price"><a href="SellConfirmation.jsp?model=" + ><button>Sell</button></a>
			</form>
		</div>
	</div>
</body>
</html>