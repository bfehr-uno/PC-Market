<%@page import="java.util.ArrayList, java.util.List, datamodel2.*, util2.UtilDBPCMarket"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<link rel="stylesheet" type="text/css" href="css/ProductDisplay.css">
	<title>Product List</title> 
</head>  
<body>
	<jsp:include page="MenuBar.jsp" />
	<div class="listings">
		<ul>
			<%
			UtilDBPCMarket.setupDB();
			List<Listing> listings = UtilDBPCMarket.listListings();
			
			for (Listing listing : listings) {
				String imgSrc = null;
				String partType = listing.getPartType();
				String id = listing.getID().toString();
				String modelName = listing.getModelName();
				String price = listing.getPrice();
								
				if (partType.equals("CPU")) {
					imgSrc = "photos/genericcpu.jpg";
				}
				else if (partType.equals("GPU")) { 
					imgSrc = "photos/genericgpu.jpg";
				}
				else if (partType.equals("Hard Drive")) {
					imgSrc = "photos/genericharddrive.jpg";
				}
				else if (partType.equals("Motherboard")) { 
					imgSrc = "photos/genericmotherboard.jpg";
				}
			%>	
				<a href="SingleListing.jsp?listinginfo=<%=id + ',' + modelName + ',' + partType + ',' + price%>"><li> 
					<div class="image"><img src="<%=imgSrc%>"></div>
					<div><%=modelName%></div>
					<div class="price">$<%=price%></div>	
				</li></a>
			<%}%>
		</ul>  
	</div>
</body>
</html> 