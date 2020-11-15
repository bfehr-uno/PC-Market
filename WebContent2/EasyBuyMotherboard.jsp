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
		<form action="EasyBuyMotherboardResult.jsp">
			<div><label>Socket Type: </label><input type="text" name="socket"></div>
			<div><label>Expansion Slots: </label><input type="text" name="expansionslots"></div>
			<div class="submit"><input type="submit" value="Search"></div>
		</form>
	</div>
</body>
</html>