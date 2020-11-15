<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="datamodel2.*"%>
<%@page import="util2.UtilDBPCMarket"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/SingleListing.css">
	</head>
	<jsp:include page="MenuBar.jsp" />
	<div class="container">
		<div class="listing">
			<%
			String listinginfo = request.getParameter("listinginfo");
			String listingInfo[] = listinginfo.split(",");
			String id = listingInfo[0];
			String partType = listingInfo[2];
			
			if (partType.equals("CPU")) {
				CPU cpu = UtilDBPCMarket.getCPU(id);
				ArrayList<String> attributes = cpu.getAttributes();
				%>
				<div class="attributes">
				<%
				for (String attribute : attributes) {%>
					<div class="attribute"><%=attribute%></div>
				<%
				}%>
				</div>
				<div>
					<div><img class="part" src="photos/genericcpu.jpg"></div>
					<div><%=cpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + cpu.getModelName() + ',' + partType + ',' + cpu.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else if (partType.equals("GPU")) {
				GPU gpu = UtilDBPCMarket.getGPU(id);%>
				<% 
				ArrayList<String> attributes = gpu.getAttributes();
				%>
				<div class="attributes">
				<%
				for (String attribute : attributes) {%>
					<div class="attribute"><%=attribute%></div>
				<%
				}%>
				</div>
				<div>
					<div><img class="part" src="photos/genericgpu.jpg"></div>
					<div><%=gpu.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + gpu.getModelName() + ',' + partType + ',' + gpu.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else if (partType.equals("Hard Drive")) {
				Hard_Drive hardDrive = UtilDBPCMarket.getHardDrive(id);%>
				<% 
				ArrayList<String> attributes = hardDrive.getAttributes();
				%>
				<div class="attributes">
				<%
				for (String attribute : attributes) {%>
					<div class="attribute"><%=attribute%></div>
				<%
				}%>
				</div>
				<div>
					<div><img class="part" src="photos/genericharddrive.jpg"></div>
					<div><%=hardDrive.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + hardDrive.getModelName() + ',' + partType + ',' + hardDrive.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%
			} else {
				Motherboard motherboard = UtilDBPCMarket.getMotherboard(id);%>
				<% 
				ArrayList<String> attributes = motherboard.getAttributes();
				%>
				<div class="attributes">
				<%
				for (String attribute : attributes) {%>
					<div class="attribute"><%=attribute%></div>
				<%
				}%>
				</div>
				<div>
					<div><img class="part" src="photos/genericmotherboard.jpg"></div>
					<div><%=motherboard.getPrice() %><a href="PurchaseConfirmation.jsp?listinginfo=<%=id + ',' + motherboard.getModelName() + ',' + partType + ',' + motherboard.getPrice()%>"><button>purchase</button></a></div>
				</div>
			<%}%>
		</div>
	</div>
</html>