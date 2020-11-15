<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datamodel2.*"%>
<%@page import="util2.UtilDBPCMarket"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<%
	String[] listingInfo = request.getParameter("listinginfo").split(",");
	String id = listingInfo[0];
	String modelName = listingInfo[1];
	String partType = listingInfo[2];
	String price = listingInfo[3];
	UtilDBPCMarket.removeListing(id, partType);
	%>
	<p>You have successfully purchased <%=modelName%> for $<%=price%>.<p>
	<a href="ProductDisplay.jsp"><button>Home</button></a>
</html>