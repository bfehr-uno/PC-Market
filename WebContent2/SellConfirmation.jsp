<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="util2.UtilDBPCMarket"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String price = request.getParameter("price");
String manufacturer = request.getParameter("manufacturer");
String modelName = request.getParameter("model");
String partType = request.getParameter("type");
if (partType.equals("CPU")) {
	String frequency = request.getParameter("frequency");
	String cores = request.getParameter("cores");
	String socket = request.getParameter("socket");
	UtilDBPCMarket.createCPU(manufacturer, modelName, frequency, cores, socket, price);
} else if (partType.equals("GPU")) {
	String clockSpeed = request.getParameter("clockspeed");
	String interf = request.getParameter("interf");
	String memory = request.getParameter("memory");
	UtilDBPCMarket.createGPU(manufacturer, modelName, clockSpeed, interf, memory, price);
} else if (partType.equals("Hard Drive")) {
	String storage = request.getParameter("storage");
	String rpm = request.getParameter("rpm");
	UtilDBPCMarket.createHard_Drive(manufacturer, modelName, storage, rpm, price);
} else {
	String socket = request.getParameter("socket");
	String expansionSlots = request.getParameter("expansionslots");
	UtilDBPCMarket.createMotherboard(manufacturer, modelName, socket, expansionSlots, price);
}
%>
	<p>You have listed <%=manufacturer + " " + modelName%> for $<%=price%><p>
	<a href="CurrentListings.jsp"><button>View Current Listings</button></a>
</body>
</html>