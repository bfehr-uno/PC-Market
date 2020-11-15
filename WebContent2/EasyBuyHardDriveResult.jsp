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
			String storage = request.getParameter("storage");
			String rpm = request.getParameter("rpm");
			List<Hard_Drive> hardDrives = UtilDBPCMarket.easyBuyHardDrive(storage, rpm);
			
			for (Hard_Drive hardDrive : hardDrives) {
				String price = hardDrive.getPrice();
				String modelName = hardDrive.getModelName();%>
				<a href="SingleListing.jsp?listinginfo=<%=hardDrive.getId() + "," + modelName + ",Hard Drive," + price%>"><li> 
					<img src="photos/genericharddrive.jpg">
					<div><%=modelName%></div>
					<div>$<%=price%></div>	
				</li></a>
			<%}%>	
		</ul>
	</div>
</body>
</html>