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
	<jsp:include page="MenuBar.jsp" />
	<div class="listings">
		<ul>
			<%
			String cores = request.getParameter("cores");
			String freq = request.getParameter("frequency");
			String socket = request.getParameter("socket");
			List<CPU> cpus = UtilDBPCMarket.easyBuyCPU(cores, freq, socket);
			System.out.println("hello");
			
			for (CPU cpu : cpus) {
				String price = cpu.getPrice();
				String modelName = cpu.getModelName();%>
				<a href="SingleListing.jsp?listinginfo=<%=cpu.getId() + "," + modelName + ",CPU,"+ price%>"><li> 
					<div class="image"><img src="photos/genericcpu.jpg"></div>
					<div><%=modelName%></div>
					<div>$<%=price%></div>	
				</li></a>
			<%}%>	
		</ul>
	</div>
</body>
</html>