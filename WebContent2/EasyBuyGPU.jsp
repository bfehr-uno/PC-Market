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
		<form action="EasyBuyGPUResult.jsp" style="height: 100%; width: 800px; display: flex; flex-direction: column; align-items: center;">
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Clock Speed: </label><input type="text" name="clockspeed"></div>
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Interface Type: </label><input type="text" name="interf"></div>
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Memory Size: </label><input type="text" name="memory"></div>
			<div class="submit" ><input type="submit" value="Search"></div>
		</form>
		</div>
	</div>
</body>
</html>