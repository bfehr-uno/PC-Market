<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/EasyBuy.css">
</head>
<body>
	<jsp:include page="MenuBar.jsp" />
	<div class="container">
		<form action="EasyBuyGPUResult.jsp">
			<div><label>Clock Speed: </label><input type="text" name="clockspeed"></div>
			<div><label>Interface Type: </label><input type="text" name="interf"></div>
			<div><label>Memory Size: </label><input type="text" name="memory"></div>
			<div class="submit"><input type="submit" value="Search"></div>
		</form>
	</div>
</body>
</html>