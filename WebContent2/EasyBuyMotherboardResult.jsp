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
			String socket = request.getParameter("socket");
			String expansionSlots = request.getParameter("expansionslots");
			List<Motherboard> motherboards = UtilDBPCMarket.easyBuyMotherboard(socket, expansionSlots);
			
			for (Motherboard motherboard : motherboards) {
				String price = motherboard.getPrice();
				String modelName = motherboard.getModelName();%>
				<a href="SingleListing.jsp?listinginfo=<%=motherboard.getId() + "," + modelName + ",Motherboard," + price%>"><li> 
					<img src="photos/genericmotherboard.jpg">
					<div><%=modelName%></div>
					<div>$<%=price%></div>	
				</li></a>
			<%}%>	
		</ul>
	</div>
</body>
</html>