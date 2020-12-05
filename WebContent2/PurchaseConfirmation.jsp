<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datamodel2.*"%>
<%@page import="util2.BuyUtil"%>
<%
Integer userID = (Integer) session.getAttribute("userID");

String listingInfo1 = request.getParameter("listinginfo");
String[] listingInfo2 = listingInfo1.split(",");
String partType = listingInfo2[0];
String partID = listingInfo2[1];
String price = listingInfo2[2];

BuyUtil.purchaseListing(userID, partType, partID, price);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body style="height: 722px; width: 1536px; display: flex; align-items: center; justify-content: center;">
	<div style="width: 500px; display: flex; flex-direction: column; align-items: center; justify-content: center;">
		<p>Successful purchase<p>
		<a href="Account.jsp"><button>Back to your account</button></a>
	</div>
</body>
</html>