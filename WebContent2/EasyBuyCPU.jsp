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
		<form class="attribute-form" action="EasyBuyCPUResult.jsp" style="height: 100%; width: 800px; display: flex; flex-direction: column; align-items: center;">
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Number of Cores: </label><input type="text" name="cores"></div>
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Frequency: </label><input type="text" name="frequency"></div>
			<div class="field" style="height: 160.5px; width: 60%; display: flex; align-items: center; justify-content: space-between;"><label>Socket Compatibility</label><input type="text" name="socket"></div>
			<div class="submit"><input type="submit" value="Search"></div>
		</form>
	</div>
</body>
</html>