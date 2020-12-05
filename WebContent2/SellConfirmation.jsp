<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="util2.SellUtil"%>
<%
Integer sellerID = (Integer) session.getAttribute("userID");
String price = request.getParameter("price");
String modelName = request.getParameter("modelName");
System.out.println(modelName);
String partType = request.getParameter("type");
if (partType.equals("CPU")) {
	String frequency = request.getParameter("frequency");
	String cores = request.getParameter("cores");
	String socket = request.getParameter("socket");
	SellUtil.listCPU(sellerID, modelName, cores, frequency, socket, price);
} else if (partType.equals("GPU")) {
	String clockSpeed = request.getParameter("clockSpeed");
	String interf = request.getParameter("interf");
	String memory = request.getParameter("memory");
	SellUtil.listGPU(sellerID, modelName, clockSpeed, interf, memory, price);
} else if (partType.equals("Hard Drive")) {
	String storage = request.getParameter("storage");
	String rpm = request.getParameter("rpm");
	SellUtil.listHardDrive(sellerID, modelName, storage, rpm, price);
} else if (partType.equals("Motherboard")) {
	String socket = request.getParameter("socket");
	String expansionSlots = request.getParameter("expansion");
	SellUtil.listMotherboard(sellerID, modelName, expansionSlots, socket, price);
} else {
	String type = request.getParameter("type");
	String capacity = request.getParameter("capacity");
	String speed = request.getParameter("speed");
	SellUtil.listRAM(sellerID, modelName, type, capacity, speed, price);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="height: 722px; width: 1536px; display: flex; align-items: center; justify-content: center;">
	<div style="width: 500px; display: flex; flex-direction: column; align-items: center; justify-content: center;">
		<p>You have listed <%=modelName%> for $<%=price%><p>
		<a href="Account.jsp"><button>Back to your account</button></a>
	</div>
</body>
</html>