<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List, datamodel2.*"%>
<%@page import="util2.UtilDBPCMarket"%>
<!DOCTYPE html>
<html>
<body>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/EasyBuyResult.css">
	</head>
	<div class="listings">
		<ul>
			<%
			String clockSpeed = request.getParameter("clockspeed");
			String interf = request.getParameter("interf");
			String memory = request.getParameter("memory");
			List<GPU> gpus = UtilDBPCMarket.easyBuyGPU(clockSpeed, interf, memory);
			
			for (GPU gpu : gpus) {
				String price = gpu.getPrice();
				String modelName = gpu.getModelName();%>
				<a href="SingleListing.jsp?listinginfo=<%=gpu.getId() + "," + modelName + ",GPU," + price%>"><li> 
					<img src="photos/genericgpu.jpg">
					<div><%=modelName%></div>
					<div>$<%=price%></div>	
				</li></a>
			<%}%>	
		</ul>
	</div>
</body>
</html>