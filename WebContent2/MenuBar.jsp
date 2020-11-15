<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/MenuBar.css">
</head>
<body>
	<div class="header">
		<div class="inner_header">
			<div class="logo_container"><a href="ProductDisplay.jsp" style="color: black;">PC Market</a></div>
			<div class="filler"></div>
			<div class="navigation">
				<div class="sell"> 
					<div class="text" >Sell</div>
				  	<div class="dropdown-content">
				  		<div><a href="SellCPU.jsp">CPU</a></div>
				  		<div><a href="SellGPU.jsp">MotherBoard</a></div>
				  		<div><a href="SellHardDrive.jsp">Hard Drive</a></div>
				  		<div><a href="SellMotherboard.jsp">Motherboard</a></div>
				  	</div>
				</div>
				<div class="easyBuy">
				  	<div class="text">Easy Buy</div>
				  	<div class="dropdown-content">
				  		<div><a href="EasyBuyCPU.jsp">CPU</a></div>
				  		<div><a href="EasyBuyGPU.jsp">MotherBoard</a></div>
				  		<div><a href="EasyBuyHardDrive.jsp">Hard Drive</a></div>
				  		<div><a href="EasyBuyMotherboard.jsp">Motherboard</a></div>
				  	</div>
				</div>
	  		</div>
		</div>
	</div>
</body>
</html>