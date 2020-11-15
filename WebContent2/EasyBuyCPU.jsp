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
	<div class="container">
		<form action="EasyBuyCPUResult.jsp">
			<div><label>Number of Cores: </label><input type="text" name="cores"></div>
			<div><label>Frequency: </label><input type="text" name="frequency"></div>
			<div><label>Socket Compatibility</label><input type="text" name="socket"></div>
			<div class="submit"><input type="submit" value="Search"></div>
		</form>
	</div>
</body>
</html>